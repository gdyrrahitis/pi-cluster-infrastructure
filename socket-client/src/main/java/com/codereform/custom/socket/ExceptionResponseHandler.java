package com.codereform.custom.socket;

public class ExceptionResponseHandler extends ResponseHandler {
    protected ExceptionResponseHandler(Exception exception) {
        super(exception.getMessage());
    }

    @Override
    public void handleResponse() {
        // TODO: Implementation
    }
}
