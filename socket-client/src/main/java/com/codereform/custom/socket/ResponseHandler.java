package com.codereform.custom.socket;

import mymessages.Response;

public abstract class ResponseHandler {
    protected String rawResponse;

    protected ResponseHandler(String response) {
        this.rawResponse = response;
    }
    protected ResponseHandler(Response.response response) {
        this(response.getMsg());
    }

    public String getResponse() {
        return rawResponse;
    }
}
