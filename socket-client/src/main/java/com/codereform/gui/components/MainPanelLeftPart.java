package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPanelLeftPart extends UiComponent {
    private List<UiComponent> _components = new ArrayList<>();

    public MainPanelLeftPart(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var sidebar = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        sidebar.setLayout(gridLayout);
        _components.stream().map(UiComponent::draw).forEach(sidebar::add);
        return sidebar;
    }

    @Override
    public void add(UiComponent component) {
        _components.add(component);
    }
}
