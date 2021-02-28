package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Mediator;

import javax.swing.*;
import java.awt.*;

public class DefaultCommandView extends Item {
    public DefaultCommandView(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var label = new JLabel("Select a command from the pane on the right");
        return label;
    }

    @Override
    public void add(Item component) { }
}
