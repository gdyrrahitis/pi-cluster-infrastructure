package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class UiComponent {
    protected final Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    protected Mediator mediator;

    public UiComponent(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract Component draw();
    public abstract void add(UiComponent component);

    public void receive(Context context) {
        // TODO: Move it to another class that derives from Item or to interface
        // Not implemented by default
    }

    protected boolean isContextDataNullOrEmpty(Context context) {
        return context.getData() != null || !context.getData().isEmpty();
    }
}
