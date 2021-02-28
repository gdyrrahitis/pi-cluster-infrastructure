package com.codereform.custom.socket;

public class ResponseContext {
    private ResponseHandler _responseHandler;

    public ResponseContext(ResponseHandler responseHandler) {
        _responseHandler = responseHandler;
    }

    public void executeResponse() throws NoSuchFieldException {
        _responseHandler.handleResponse();
    }
}
