package com.codereform.client;

import com.codereform.custom.socket.ResponseContext;
import com.codereform.custom.socket.ShutdownCommandHandler;

public class socketClient {
    public static void main(String[] args) {
        var handler = new ShutdownCommandHandler();
        var response = handler.Handle(null);
        var context = new ResponseContext(response);
        context.executeResponse();
    }
}
