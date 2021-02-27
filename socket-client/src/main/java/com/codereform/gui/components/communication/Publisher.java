package com.codereform.gui.components.communication;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void notifySubscribers(Context context);
}
