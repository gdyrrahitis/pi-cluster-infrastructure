package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Item {
    private List<Item> _components = new ArrayList<>();

    @Override
    public Component draw() {
        var main = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        main.setLayout(gridLayout);
        _components.stream().map(Item::draw).forEach(main::add);
        return main;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }
}
