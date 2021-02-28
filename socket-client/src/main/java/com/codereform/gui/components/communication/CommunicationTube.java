package com.codereform.gui.components.communication;

import com.codereform.gui.components.Item;

import java.util.HashMap;
import java.util.List;

public class CommunicationTube extends Mediator {
    private final HashMap<Class, List<Item>> registrations = new HashMap<>();

    @Override
    public void registerOrReplace(Class type, Item item) {
        if(registrations.containsKey(type)) {
            registrations.remove(type);
        }

        registrations.put(type, List.of(item));
    }

    @Override
    public void register(Class type, Item item) {
        if(registrations.containsKey(type)) {
            var values = registrations.get(type);
            values.add(item);
            registrations.replace(type, values);
        } else {
            registrations.put(type, List.of(item));
        }
    }

    @Override
    public void register(Class type, List<Item> items) {
        if(registrations.containsKey(type)) {
            var values = registrations.get(type);
            values.addAll(items);
            registrations.replace(type, values);
        } else {
            registrations.put(type, items);
        }
    }

    @Override
    public void send(ComponentNotification notification, Context context) {
        var receivers = registrations.get(notification.getClass());
        if(receivers != null || !receivers.isEmpty()) {
            receivers.stream().forEach(item -> item.receive(context));
        }
    }
}
