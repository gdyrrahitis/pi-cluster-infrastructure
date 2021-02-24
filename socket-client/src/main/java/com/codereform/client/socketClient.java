package com.codereform.client;

import com.codereform.custom.socket.ResponseContext;
import com.codereform.custom.socket.ShutdownCommandHandler;

import javax.swing.*;

public class socketClient {
    public static void main(String[] args) {
        var frame = new JFrame();
        var button = new JButton("Click");
        button.setBounds(130, 100, 100, 40);
        button.addActionListener(e -> {
            frame.invalidate();
        });
        frame.add(button);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
//        var handler = new ShutdownCommandHandler();
//        var response = handler.Handle(null);
//        var context = new ResponseContext(response);
//        context.executeResponse();
    }
}
