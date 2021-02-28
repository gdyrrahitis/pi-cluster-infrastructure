package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Container extends UiComponent {
    private List<UiComponent> _components = new ArrayList<>();
    private JFrame _frame;

    public Container(Mediator mediator, JFrame frame) {
        super(mediator);

        _frame = frame;
    }

    @Override
    public Component draw() {
        var container = _frame.getContentPane();
        var containerGrid = new GridLayout(2, 1);
        container.setLayout(containerGrid);
        _components.stream().map(UiComponent::draw).forEach(container::add);
        return container;
    }

    @Override
    public void add(UiComponent component) {
        _components.add(component);
    }
}
