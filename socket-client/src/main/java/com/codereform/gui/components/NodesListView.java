package com.codereform.gui.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NodesListView extends Item {
    private final Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    @Override
    public Component draw() {
        var listModel = new DefaultListModel<>();
        listModel.addElement("*");
        listModel.addElement("rpizero-master");
        listModel.addElement("rpizero-node1");
        listModel.addElement("rpizero-node2");
        listModel.addElement("rpizero-node3");
        listModel.addElement("rpizero-node4");
        listModel.addElement("rpizero-loadbalancer");
        var listView = new JList<>(listModel);
        listView.setSelectedIndex(0);
        listView.setBorder(border);
        return listView;
    }

    @Override
    public void add(Item component) { }
}
