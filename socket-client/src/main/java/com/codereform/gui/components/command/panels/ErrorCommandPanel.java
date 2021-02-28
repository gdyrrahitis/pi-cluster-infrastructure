package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public class ErrorCommandPanel extends UiComponent {
    private String errorMessage;

    public ErrorCommandPanel(Mediator mediator, String errorMessage) {
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
    public void add(UiComponent component) { }

    @Override
    public void receive(Context context) { }
}
