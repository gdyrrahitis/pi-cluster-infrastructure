package com.codereform.gui.components.command.panels;

import com.codereform.socket.client.sender.ShutdownCommandSender;
import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.ResponseReceivedNotification;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShutdownCommandPanel extends UiComponent {
    private List<String> nodes = List.of("*");

    public ShutdownCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var button = new JButton("Shutdown");
        button.addActionListener(e -> {
            var handler = new ShutdownCommandSender();
            var response = handler.handle(nodes);
            var notification = new ResponseReceivedNotification();
            var context = new Context(ListViewAction.response, response.getResponse());
            mediator.send(notification, context);
        });
        return button;
    }

    @Override
    public void add(UiComponent component) { }

    @Override
    public void receive(Context context) {
        if(context.getAction() == ListViewAction.nodesUpdate) {
            nodes = Arrays.stream(context.getData().split(",")).collect(Collectors.toList());
        } else {
            System.err.println(String.format("Cannot handle '%s' action. %s", context.getAction(), this.getClass().getName()));
        }
    }
}
