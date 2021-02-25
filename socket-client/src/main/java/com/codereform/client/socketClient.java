package com.codereform.client;

import com.codereform.gui.components.ClientFrame;
import com.codereform.gui.components.WindowClient;

import javax.swing.*;

public class socketClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new ClientFrame();
                var window = new WindowClient();
                window.draw();
            }
        });
    }
}
