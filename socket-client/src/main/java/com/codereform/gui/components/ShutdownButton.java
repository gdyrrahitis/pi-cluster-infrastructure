package com.codereform.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShutdownButton extends JButton {
    public ShutdownButton() {
        super("Shutdown");
    }

    @Override
    protected ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Custom action listener");
            }
        };
    }
}
