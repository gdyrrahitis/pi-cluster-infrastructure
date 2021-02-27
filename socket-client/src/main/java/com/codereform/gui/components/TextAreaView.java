package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;

public class TextAreaView extends Item implements Subscriber {
    private final Insets _margin = new Insets(10, 10, 10, 10);
    private JTextArea _responseArea = new JTextArea();

    @Override
    public Component draw() {
        _responseArea.setEnabled(false);
        _responseArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        _responseArea.setMargin(_margin);
        return _responseArea;
    }

    @Override
    public void add(Item component) { }

    @Override
    public void update(Context context) {
        if(context.getAction() == ListViewAction.response) {
            _responseArea.setText(context.getData());
        } else {
            _responseArea.setText("");
        }
    }
}
