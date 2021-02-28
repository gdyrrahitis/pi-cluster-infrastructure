package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Container extends UiComponent {
    private List<UiComponent> components = new ArrayList<>();
    private JFrame frame;

    public Container(Mediator mediator, JFrame frame) {
        super(mediator);
        this.frame = frame;
    }

    @Override
    public Component draw() {
        var container = frame.getContentPane();
        var gridLayout = new GridLayout(2, 1);
        container.setLayout(gridLayout);
        components.stream().map(UiComponent::draw).forEach(container::add);
        return container;
    }

    @Override
    public void add(UiComponent component) {
        components.add(component);
    }
}
