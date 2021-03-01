package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.google.inject.Inject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends UiComponent {
    private List<UiComponent> components = new ArrayList<>();

    @Inject
    public MainPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var main = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        main.setLayout(gridLayout);
        components.stream().map(UiComponent::draw).forEach(main::add);
        return main;
    }

    @Override
    public void add(UiComponent component) {
        components.add(component);
    }
}
