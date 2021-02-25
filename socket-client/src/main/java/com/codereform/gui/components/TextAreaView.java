package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;

public class TextAreaView extends Item {
    private final Insets _margin = new Insets(10, 10, 10, 10);
    @Override
    public Component draw() {
        var responseArea = new JTextArea();
        responseArea.setText("BLAH BLAH BLAH");
        responseArea.setEnabled(false);
        responseArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        responseArea.setMargin(_margin);
        return responseArea;
    }

    @Override
    public void add(Item component) { }
}
