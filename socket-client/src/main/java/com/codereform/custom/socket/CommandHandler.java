package com.codereform.custom.socket;

import com.codereform.commands.ICommand;
import com.codereform.commands.ShutdownCommand;
import mymessages.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public abstract class CommandHandler {
    private static final String address = "192.168.0.136";
    private static final int port = 8080;

    abstract ICommand getCommand(List<String> nodes);

    public final IResponseHandler Handle(List<String> nodes) {
        try (var socket = new Socket(address, port)){
            var command = getCommand(nodes);
            System.out.println("Connected with server...");

            try(
                    var outputStream = socket.getOutputStream();
                    var inputStream = socket.getInputStream();
                    var buffer = new ByteArrayOutputStream()
            ) {
                command.createCommand().writeTo(outputStream);
                int ch;
                byte[] data = new byte[1024];
                while((ch = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, ch);
                }

                var response = Response.response.parseFrom(buffer.toByteArray());
                if(response.hasIsError() && response.getIsError()) {
                    System.err.println("ERR: There was an error returned from server: " + response.getMsg());
                    return new ErrorResponseHandler();
                } else {
                    System.out.println("Response message: " + response.getMsg());
                    return new SuccessfulResponseHandler();
                }
            }
        }
        catch (IOException ex) {
            // TODO: Handle socket error
            System.err.println(String.format("Error with socket descriptor. %s", ex.getMessage()));
            return new ExceptionResponseHandler();
        }
        catch(Exception ex) {
            // TODO: Handle generic error
            System.err.println(ex.getMessage());
            return new ExceptionResponseHandler();
        }
    }
}
