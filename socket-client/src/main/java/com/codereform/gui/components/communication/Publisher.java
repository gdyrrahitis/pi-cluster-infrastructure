package com.codereform.gui.components.communication;

import com.codereform.gui.components.Item;

public interface Publisher {
    void subscribe(Subscriber subscriber, Item component);
    void notifySubscribers(Context context);
}
