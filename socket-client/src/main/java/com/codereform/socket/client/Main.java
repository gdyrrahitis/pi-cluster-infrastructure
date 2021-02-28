package com.codereform.socket.client;

import com.codereform.gui.components.WindowPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var window = new WindowPanel();
            window.draw();
        });
    }
}
