package com.codereform.gui.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CommandsListView extends Item {
    private final Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    @Override
    public Component draw() {
        var commandListModel = new DefaultListModel<>();
        commandListModel.addElement("Shutdown");
        var commandListView = new JList<>(commandListModel);
        commandListView.setBorder(border);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(Item component) { }
}
