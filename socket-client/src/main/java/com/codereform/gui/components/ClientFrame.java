package com.codereform.gui.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClientFrame {
    private final Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    public ClientFrame() {
        var frame = new JFrame("Raspberry Pi Cluster Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var container = frame.getContentPane();
        var containerGrid = new GridLayout(2, 1);
        container.setLayout(containerGrid);

        var main = new JPanel();
        var gridLayout = new GridLayout(1, 3);
        main.setLayout(gridLayout);

        var sidebar = new JPanel();
        var gridLayout2 = new GridLayout(1, 3);
        sidebar.setLayout(gridLayout2);

        var commandListModel = new DefaultListModel<>();
        commandListModel.addElement("Shutdown");
        var commandListView = new JList<>(commandListModel);
        commandListView.setBorder(border);
        var scrollLayout = new JScrollPane(commandListView);
        sidebar.add(scrollLayout);

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

        sidebar.add(listView);
        main.add(sidebar);

        var commandPanel = new JPanel();
        var mainBoxLayout = new BoxLayout(commandPanel, BoxLayout.Y_AXIS);
        commandPanel.setLayout(mainBoxLayout);
        commandPanel.add(new JButton("Execute Command"));
        commandPanel.setBorder(border);
        main.add(commandPanel);

        var footer = new JPanel();
        var responseArea = new JTextArea();
        responseArea.setText("BLAH BLAH BLAH");
        responseArea.setEnabled(false);
        responseArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        responseArea.setMargin(new Insets(10, 10, 10, 10));
        var boxLayout2 = new BoxLayout(footer, BoxLayout.Y_AXIS);
        footer.setLayout(boxLayout2);
        footer.add(responseArea);

        container.add(main);
        container.add(footer);

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
