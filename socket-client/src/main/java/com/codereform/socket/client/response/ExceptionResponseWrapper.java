package com.codereform.socket.client.response;

public class ExceptionResponseWrapper extends ResponseWrapper {
    public ExceptionResponseWrapper(Exception exception) {
        super(exception.getMessage());
    }

    @Override
    public ResponseType getType() {
        return ResponseType.exception;
    }
}
