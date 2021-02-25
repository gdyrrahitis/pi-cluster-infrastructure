package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Footer extends Item {
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var footer = new JPanel();
        var responseArea = new JTextArea();
        responseArea.setText("BLAH BLAH BLAH");
        responseArea.setEnabled(false);
        responseArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        responseArea.setMargin(new Insets(10, 10, 10, 10));
        var boxLayout2 = new BoxLayout(footer, BoxLayout.Y_AXIS);
        footer.setLayout(boxLayout2);
        footer.add(responseArea);
        _components.stream().map(Item::draw).forEach(footer::add);
        return footer;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
