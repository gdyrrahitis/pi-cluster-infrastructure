package com.codereform.gui.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainRightPart extends Item {
    private final Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var commandPanel = new JPanel();
        var mainBoxLayout = new BoxLayout(commandPanel, BoxLayout.Y_AXIS);
        commandPanel.setLayout(mainBoxLayout);
        commandPanel.add(new JButton("Execute Command"));
        commandPanel.setBorder(border);
        _components.stream().map(Item::draw).forEach(commandPanel::add);
        return commandPanel;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
