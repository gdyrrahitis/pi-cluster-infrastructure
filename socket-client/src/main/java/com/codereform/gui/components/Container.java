package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Container extends Item {
    private List<Item> _components = new ArrayList<>();
    private JFrame _frame;

    public Container(JFrame frame) {
        _frame = frame;
    }

    @Override
    public Component draw() {
        var container = _frame.getContentPane();
        var containerGrid = new GridLayout(2, 1);
        container.setLayout(containerGrid);

        _components.stream().map(Item::draw).forEach(container::add);
        return container;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
