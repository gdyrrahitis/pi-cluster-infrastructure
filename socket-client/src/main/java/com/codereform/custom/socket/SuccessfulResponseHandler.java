package com.codereform.custom.socket;

import mymessages.Response;

import java.awt.*;

public class SuccessfulResponseHandler extends ResponseHandler {
    private final Color color = Color.green;
    public SuccessfulResponseHandler(String response) {
        super(response);
    }

    public SuccessfulResponseHandler(Response.response response) {
        super(response);
    }

    @Override
    public void handleResponse() {
        // TODO: Implementation
    }
}
