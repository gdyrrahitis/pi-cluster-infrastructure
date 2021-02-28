package com.codereform.gui.components;

import javax.swing.*;

public abstract class WindowBase {
    protected abstract void drawComponents(JFrame frame);
    private final String title = "Raspberry Pi Cluster Manager";

    public void draw() {
        var frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponents(frame);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
