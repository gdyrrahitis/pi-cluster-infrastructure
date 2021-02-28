package com.codereform.socket.client.sender;

import com.codereform.socket.client.commands.ICommand;
import com.codereform.socket.client.response.ErrorResponseWrapper;
import com.codereform.socket.client.response.ExceptionResponseWrapper;
import com.codereform.socket.client.response.ResponseWrapper;
import com.codereform.socket.client.response.SuccessfulResponseWrapper;
import mymessages.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public abstract class CommandSender {
    private static final String address = "192.168.0.136";
    private static final int port = 8080;
    private final int bufferSize = 1024;
    private final int offset = 0;

    abstract ICommand getCommand(List<String> nodes);

    public final ResponseWrapper handle(List<String> nodes) {
        try (var socket = new Socket(address, port)){
            var command = getCommand(nodes);

            try(
                    var outputStream = socket.getOutputStream();
                    var inputStream = socket.getInputStream();
                    var buffer = new ByteArrayOutputStream()
            ) {
                command.createCommand().writeTo(outputStream);
                int ch;
                byte[] data = new byte[bufferSize];
                while((ch = inputStream.read(data, offset, data.length)) != -1) {
                    buffer.write(data, offset, ch);
                }

                var response = Response.response.parseFrom(buffer.toByteArray());
                return isSuccessfulResponse(response) ?
                        new SuccessfulResponseWrapper(response):
                        new ErrorResponseWrapper(response);
            }
        }
        catch (IOException ex) {
            System.err.println(String.format("Error with socket descriptor. %s", ex.getMessage()));
            return new ExceptionResponseWrapper(ex);
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            return new ExceptionResponseWrapper(ex);
        }
    }

    private boolean isSuccessfulResponse(Response.response response) {
        return !(response.hasIsError() && response.getIsError());
    }
}
