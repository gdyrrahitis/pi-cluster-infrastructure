package com.codereform.gui.components.communication;

import com.codereform.gui.components.Item;

import java.util.List;

public abstract class Mediator {
    public abstract void registerOrReplace(Class type, Item item);
    public abstract void register(Class type, Item item);
    public abstract void register(Class type, List<Item> items);
    public abstract void send(ComponentNotification notification, Context context);
}
