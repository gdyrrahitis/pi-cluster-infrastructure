package com.codereform.gui.components;

import javax.swing.*;

public abstract class WindowBase {
    protected JFrame frame;
    protected abstract void drawComponents(JFrame frame);

    public WindowBase(JFrame frame) {
        this.frame = frame;
    }

    public void draw() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponents(frame);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
