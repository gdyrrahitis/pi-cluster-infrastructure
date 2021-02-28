package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.Mediator;

import javax.swing.*;
import java.awt.*;

public class ErrorCommandView extends Item {
    private String errorMessage;

    public ErrorCommandView(Mediator mediator, String errorMessage) {
        super(mediator);

        this.errorMessage = errorMessage;
    }

    @Override
    public Component draw() {
        var label = new JLabel(errorMessage);
        label.setForeground(Color.red);
        return label;
    }

    @Override
    public void add(Item component) { }

    @Override
    public void receive(Context context) {
        // TODO: RECEIVE IMPLEMENTATION
    }
}
