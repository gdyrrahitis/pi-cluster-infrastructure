package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.Mediator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Item {
    protected final Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    protected Mediator mediator;

    public Item(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract Component draw();
    public abstract void add(Item component);

    public void receive(Context context) {
        // TODO: Move it to another class that derives from Item or to interface
        // Not implemented by default
    }
}
