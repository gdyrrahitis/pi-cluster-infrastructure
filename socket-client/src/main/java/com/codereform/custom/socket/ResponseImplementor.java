package com.codereform.custom.socket;

import com.codereform.gui.components.communication.*;

public abstract class ResponseImplementor {
    private Mediator mediator;

    public ResponseImplementor(Mediator mediator) {
        this.mediator = mediator;
    }

    public void handleResponse(String response) {
        var notification = getNotification();
        var context = getContext();
        mediator.send(notification, context);
    }

    protected ComponentNotification getNotification() {
        return new ResponseReceivedNotification();
    }

    protected abstract Context getContext();
}
