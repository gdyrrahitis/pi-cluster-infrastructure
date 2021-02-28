package com.codereform.gui.components.communication.mediator;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.notifications.ComponentNotification;

import java.util.HashMap;
import java.util.List;

public class CommunicationTube extends Mediator {
    private final HashMap<Class, List<UiComponent>> registrations = new HashMap<>();

    @Override
    public void registerOrReplace(Class type, UiComponent uiComponent) {
        if(registrations.containsKey(type)) {
            registrations.remove(type);
        }

        registrations.put(type, List.of(uiComponent));
    }

    @Override
    public void register(Class type, UiComponent uiComponent) {
        if(registrations.containsKey(type)) {
            var values = registrations.get(type);
            values.add(uiComponent);
            registrations.replace(type, values);
        } else {
            registrations.put(type, List.of(uiComponent));
        }
    }

    @Override
    public void register(Class type, List<UiComponent> uiComponents) {
        if(registrations.containsKey(type)) {
            var values = registrations.get(type);
            values.addAll(uiComponents);
            registrations.replace(type, values);
        } else {
            registrations.put(type, uiComponents);
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
