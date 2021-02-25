package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainLeftPart extends Item {
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var sidebar = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        sidebar.setLayout(gridLayout);
        _components.stream().map(Item::draw).forEach(sidebar::add);
        return sidebar;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
