package com.codereform.gui.components;

import com.codereform.gui.components.communication.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Footer extends Item {
    private List<Item> _components = new ArrayList<>();

    public Footer(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var footer = new JPanel();
        var boxLayout2 = new BoxLayout(footer, BoxLayout.Y_AXIS);
        footer.setLayout(boxLayout2);
        _components.stream().map(Item::draw).forEach(footer::add);
        return footer;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
