package com.codereform.gui.components.communication.mediator;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.notifications.ComponentNotification;

import java.util.List;

public abstract class Mediator {
    public abstract void registerOrReplace(Class type, UiComponent uiComponent);
    public abstract void register(Class type, UiComponent uiComponent);
    public abstract void register(Class type, List<UiComponent> uiComponents);
    public abstract void send(ComponentNotification notification, Context context);
}
