package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public class TextAreaView extends UiComponent {
    private final Insets margin = new Insets(10, 10, 10, 10);
    private JTextArea textArea = new JTextArea();

    public TextAreaView(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        textArea.setEnabled(false);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textArea.setMargin(margin);
        return textArea;
    }

    @Override
    public void add(UiComponent component) { }

    public void receive(Context context) {
        if(context.getAction() == ListViewAction.response) {
            textArea.setText(context.getData());
        } else {
            textArea.setText("");
        }
    }
}
