package com.codereform.custom.socket;

import mymessages.Response;

public abstract class ResponseHandler {
    private String response;
    private ResponseImplementor implementor;

    protected ResponseHandler(String response) {
        this.response = response;
    }

    protected ResponseHandler(Response.response response) {
        this(response.getMsg());
    }

    public void handleResponse() throws NoSuchFieldException {
        if(implementor != null) {
            implementor.handleResponse(response);
        } else {
            throw new NoSuchFieldException("Implementor field is not set");
        }
    }

    public void setImplementor(ResponseImplementor implementor) {
        this.implementor = implementor;
    }
}
