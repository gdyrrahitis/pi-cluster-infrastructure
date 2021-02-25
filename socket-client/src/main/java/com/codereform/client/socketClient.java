package com.codereform.client;

import com.codereform.gui.components.ClientFrame;

import javax.swing.*;

public class socketClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientFrame();
            }
        });
    }
}
