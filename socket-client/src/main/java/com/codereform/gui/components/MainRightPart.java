package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainRightPart extends Item implements Subscriber {
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var commandPanel = new JPanel();
        var mainBoxLayout = new BoxLayout(commandPanel, BoxLayout.Y_AXIS);
        commandPanel.setLayout(mainBoxLayout);
        commandPanel.setBorder(emptyBorder);
        _components.stream().map(Item::draw).forEach(commandPanel::add);
        return commandPanel;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }

    @Override
    public void update(Context context) {
        // provide action to strategy pattern
        // this will generate the handler to handle the action
        // 1) command: redraws the component (remove and then add and then redraw frame) - with the appropriate button
        // 2) nodesUpdate: sends list with nodes to button - button is a subscriber then

        // provide name to strategy pattern
        // this will generate new button
    }
}
