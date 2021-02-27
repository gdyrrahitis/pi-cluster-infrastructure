package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;

import javax.swing.*;
import java.awt.*;

public class ErrorCommandView extends Item {
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
}
