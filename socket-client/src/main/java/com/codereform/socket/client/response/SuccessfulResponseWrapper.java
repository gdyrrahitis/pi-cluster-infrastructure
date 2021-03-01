package com.codereform.socket.client.response;

import ClusterProtos.Response;

public class SuccessfulResponseWrapper extends ResponseWrapper {
    public SuccessfulResponseWrapper(Response.ServerResponse response) {
        super(response);
    }
}
