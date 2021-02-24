package com.codereform.custom.socket;

public class ResponseContext {
    private IResponseHandler _responseHandler;

    public ResponseContext(IResponseHandler responseHandler) {
        _responseHandler = responseHandler;
    }

    public void executeResponse() {
        _responseHandler.handleResponse();
    }
}
