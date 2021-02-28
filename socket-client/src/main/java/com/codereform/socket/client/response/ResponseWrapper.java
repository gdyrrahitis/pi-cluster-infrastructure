package com.codereform.socket.client.response;

import mymessages.Response;

public abstract class ResponseWrapper {
    protected String rawResponse;

    protected ResponseWrapper(String response) {
        this.rawResponse = response;
    }
    protected ResponseWrapper(Response.response response) {
        this(response.getMsg());
    }

    public String getResponse() {
        return rawResponse;
    }
}
