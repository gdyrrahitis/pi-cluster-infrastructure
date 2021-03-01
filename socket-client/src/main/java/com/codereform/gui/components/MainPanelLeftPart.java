package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.google.inject.Inject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanelLeftPart extends UiComponent {
    private List<UiComponent> components = new ArrayList<>();

    @Inject
    public MainPanelLeftPart(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var sidebar = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        sidebar.setLayout(gridLayout);
        components.stream().map(UiComponent::draw).forEach(sidebar::add);
        return sidebar;
    }

    @Override
    public void add(UiComponent component) {
        components.add(component);
    }
}
