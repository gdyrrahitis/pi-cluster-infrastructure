package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public class DefaultCommandPanel extends UiComponent {
    public DefaultCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var label = new JLabel("Select a command from the pane on the right");
        return label;
    }

    @Override
    public void add(UiComponent component) { }
}