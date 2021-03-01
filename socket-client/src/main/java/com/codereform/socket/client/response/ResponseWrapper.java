package com.codereform.socket.client.response;

import ClusterProtos.Response;

public abstract class ResponseWrapper {
    protected String rawResponse;

    protected ResponseWrapper(String response) {
        this.rawResponse = response;
    }
    protected ResponseWrapper(Response.ServerResponse response) {
        this(response.getMsg());
    }

    public String getResponse() {
        return rawResponse;
    }
}
