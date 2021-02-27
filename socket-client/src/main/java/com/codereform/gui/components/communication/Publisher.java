package com.codereform.gui.components.communication;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void unsubscribeAll();
    void notifySubscribers(Context context);
}
