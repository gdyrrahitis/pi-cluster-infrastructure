package com.codereform.socket.client.response;

import ClusterProtos.Response;

public class ErrorResponseWrapper extends ResponseWrapper {
    public ErrorResponseWrapper(Response.ServerResponse response) { super(response); }

    @Override
    public ResponseType getType() {
        return ResponseType.error;
    }
}
