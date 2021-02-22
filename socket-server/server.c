#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <signal.h>
#include "command.pb-c.h"
#include "response.pb-c.h"

#define MAX_PENDING 3
#define PORT_NUMBER 8080
#define RECVBUFFERSIZE 1024
#define MAX_RETRIES 5
#define SLEEP_BETWEEN_RETRIES 1

void HandleTcpClient(int clientSocket, char *addr);
void TerminateWithError(char *errorMessage);
void InterruptSignalHandler(int signalType);
void SetErrorResponse(Response resp, char *msg);

/*
TODO:
1) Timeout
3) recv buffer -- check if bytes are enough
4) Add more properties in command.proto
*/
int main (int argc, char *argv[]) {
    int server_socket, client_socket, on=1;
    struct sockaddr_in serverAddress, clientAddress;
    struct sigaction handler;
    unsigned int clientLength;

    handler.sa_handler = InterruptSignalHandler;
    if(sigfillset(&handler.sa_mask) < 0) {
        TerminateWithError("sigfillset() failed");
    }

    handler.sa_flags = 0;
    if(sigaction(SIGINT, &handler, 0) < 0) {
        TerminateWithError("sigaction() failed");
    }

    server_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (server_socket < 0) {
        TerminateWithError("socket() failed");
    }

    if(setsockopt(server_socket, SOL_SOCKET, SO_REUSEADDR, &on, sizeof(on)) < 0) {
        TerminateWithError("setsockopt(SO_REUSEADDR) failed");
    }

    if(setsockopt(server_socket, SOL_SOCKET, SO_REUSEPORT, &on, sizeof(on)) < 0) {
        TerminateWithError("setsockopt(SO_REUSEPORT) failed");
    }

    memset(&serverAddress, 0, sizeof(serverAddress));
    serverAddress.sin_family = AF_INET;
    serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);
    serverAddress.sin_port = htons(PORT_NUMBER);

    if(bind(server_socket, (struct sockaddr *) &serverAddress, sizeof(serverAddress)) < 0) {
        TerminateWithError("bind() failed.");
    }

    if(listen(server_socket, MAX_PENDING) < 0) {
        TerminateWithError("listen() failed");
    }

    for(;;) {
        clientLength = sizeof(client_socket);

        client_socket = accept(server_socket, (struct sockaddr *)&client_socket, &clientLength);
        if(client_socket < 0) {
            TerminateWithError("accept() failed");
        }

        char *addr = inet_ntoa(clientAddress.sin_addr);
        printf("Handling client %s\n", addr);
        HandleTcpClient(client_socket, addr);
    }

    close(server_socket);
    free(server_socket);
    exit(EXIT_SUCCESS);
}

void HandleTcpClient(int clientSocket, char *addr) {
    FILE *fp;
    AnsibleCommand *msg;
    Response resp = RESPONSE__INIT;
    void *respBuf;
    unsigned respBufLen;
    uint8_t buffer[RECVBUFFERSIZE];
    int recvMessageSize, retryCount = 0, fileSize;
    char *path = "/home/playbooks/";
    char *extension = ".yml";
    char *playbook;
    char *cmd;
    char *ansiblePlaybookCmd = "ansible-playbook -b ";
    char *output;
    size_t outputLen = 0;

    recvMessageSize = recv(clientSocket, buffer, sizeof(buffer), 0);
    if(recvMessageSize < 0) {
        TerminateWithError("recv() failed");
    }

    printf("Receiving request from client %s\n with bytes: %d\n", addr, recvMessageSize);
    // Read & deserialize proto message
    msg = ansible_command__unpack(NULL, recvMessageSize, buffer);
    if (msg == NULL) {
        char *errResponse = "ERR: Error in unpacking incoming message";
        puts(errResponse);
        resp.has_iserror = 1;
        resp.iserror = 1;
        resp.msg = errResponse;
    } else {
        puts("Received incoming message successfully");
        printf("Command: %s. Nodes: %s\n", msg->command, msg->nodes);
        // execute ansible playbook here
        // TODO: Determine which nodes to execute against

        playbook = (char *)malloc(
            strlen(msg->command) + 
            strlen(path) + 
            strlen(extension));

        strcpy(playbook, path);
        strcat(playbook, msg->command);
        strcat(playbook, extension);
        printf("Executing playbook in path '%s'\n", playbook);
        cmd = (char *)malloc(strlen(ansiblePlaybookCmd) + strlen(playbook));
        strcpy(cmd, ansiblePlaybookCmd);
        strcat(cmd, playbook);

        fp = popen(cmd, "r");

        // Ansible response here
        if(fp == NULL) {
            char *errResponse = "ERR: Error in executing command";
            puts(errResponse);
            resp.has_iserror = 1;
            resp.iserror = 1;
            resp.msg = errResponse;
        } else {
            // TODO: THIS MUST BE FIXED
            // puts("Reading file stream");
            // // if(fseek(fp, 0, SEEK_END) < 0) {
            // //     // handle error
            // //     perror("fseek() to end of stream failed");
            // //     exit(EXIT_FAILURE);
            // // }
            
            // // fileSize = ftell(fp);
            // // rewind(fp);
            // char resultBuffer[255];
            // char *res;
            // char *c;
            // int counter = 0;
            // int bufferSize = 255;
            // res = (char *)calloc(bufferSize, sizeof(char));
            // // memset(resultBuffer, 0, fileSize);
            // // fread(resultBuffer, 1, fileSize, fp);
            // // strcpy(resp.msg, resultBuffer);
            // while (fgets(resultBuffer, sizeof(resultBuffer), fp) != NULL) {
            //     printf("%s (%d)\n", resultBuffer, sizeof(resultBuffer));
            //     if(counter > 1) {
            //         res = (char *)realloc(res, bufferSize*=2);
            //     }
            //     memset(res, resultBuffer, sizeof(resultBuffer));
            //     counter++;
            // }

            // puts("*****************");
            // printf("%s", res);
            resp.msg = "Success";
        }

        pclose(fp);
    }

    // Send back response - serialize response message
    puts("Sending response back to the client");
    respBufLen = response__get_packed_size(&resp);
    respBuf = malloc(respBufLen);
    response__pack(&resp, respBuf);
    while(send(clientSocket, respBuf, respBufLen, 0) == -1) {
        printf("send() failed, retrying... Retry count is %d currently", retryCount);
        if(retryCount >= MAX_RETRIES) {
            perror("Reached max retries, server cannot send response to client");
            break;
        }

        sleep(SLEEP_BETWEEN_RETRIES);
        retryCount += 1;
    }
    
    printf("Closing connection with client %s\n", addr);
    ansible_command__free_unpacked(msg, NULL);
    free(respBuf);
    close(clientSocket);
}

void TerminateWithError(char *errorMessage) {
    perror(errorMessage);
    exit(EXIT_FAILURE);
}

void InterruptSignalHandler(int signalType) {
    puts("Interrupt received, server is terminating\n");
    exit(EXIT_SUCCESS);
}

void SetErrorResponse(Response resp, char *msg) {
    puts(msg);
    resp.has_iserror = 1;
    resp.iserror = 1;
    resp.msg = msg;
}
