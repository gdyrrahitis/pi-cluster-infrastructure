package com.codereform.gui.components.commandview;

import com.codereform.custom.socket.ShutdownCommandHandler;
import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Mediator;
import com.codereform.gui.components.communication.ResponseReceivedNotification;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShutdownCommandView extends Item {
    private List<String> nodes = List.of("*");

    public ShutdownCommandView(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var button = new JButton("Shutdown");
        button.addActionListener(e -> {
            var handler = new ShutdownCommandHandler();
            var response = handler.Handle(nodes);
            var notification = new ResponseReceivedNotification();
            var context = new Context(ListViewAction.response, response.getResponse());
            mediator.send(notification, context);
        });
        return button;
    }

    @Override
    public void add(Item component) {

    }

    @Override
    public void receive(Context context) {
        if(context.getAction() == ListViewAction.nodesUpdate) {
            nodes = Arrays.stream(context.getData().split(",")).collect(Collectors.toList());
        } else {
            System.err.println(String.format("Cannot handle '%s' action. %s", context.getAction(), this.getClass().getName()));
        }
    }
}
