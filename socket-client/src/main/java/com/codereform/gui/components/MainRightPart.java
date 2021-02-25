package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainRightPart extends Item {
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var commandPanel = new JPanel();
        var mainBoxLayout = new BoxLayout(commandPanel, BoxLayout.Y_AXIS);
        commandPanel.setLayout(mainBoxLayout);
        commandPanel.setBorder(emptyBorder);
        // TODO: Button strategy pattern???
        _components.stream().map(Item::draw).forEach(commandPanel::add);
        return commandPanel;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
