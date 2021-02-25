package com.codereform.gui.components;

import javax.swing.*;

public class WindowClient {
    public void draw() {
        var frame = new JFrame("Raspberry Pi Cluster Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var container = new Container(frame);
        var main = new Main();
        var left = new MainLeftPart();
        var right = new MainRightPart();

        var commandsListView = new CommandsListView();
        var nodesListView = new NodesListView();
        left.add(commandsListView);
        left.add(nodesListView);
        main.add(left);
        main.add(right);

        var footer = new Footer();
        container.add(main);
        container.add(footer);
        container.draw();

        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
