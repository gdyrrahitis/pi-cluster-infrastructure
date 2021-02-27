package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;

public class ErrorCommandView extends Item implements Subscriber {
    private String errorMessage;

    public ErrorCommandView(String errorMessage) {
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
    public void update(Context context) {

    }
}
