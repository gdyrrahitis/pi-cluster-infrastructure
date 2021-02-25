package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;

public class CommandsListView extends Item {
    @Override
    public Component draw() {
        var commandListModel = new DefaultListModel<>();
        commandListModel.addElement("Shutdown");
        var commandListView = new JList<>(commandListModel);
        commandListView.setBorder(emptyBorder);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(Item component) { }
}
