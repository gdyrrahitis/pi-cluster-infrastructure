package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.ResponseReceivedNotification;
import com.codereform.socket.client.sender.CommandSender;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ActionableCommandPanel extends UiComponent {
    // default nodes
    protected List<String> nodes = List.of("*");

    public ActionableCommandPanel(Mediator mediator) {
        super(mediator);
    }

    protected abstract JButton getButton();
    protected abstract CommandSender getSender();

    @Override
    public Component draw() {
        var button = getButton();
        button.addActionListener(e -> {
            var handler = getSender();
            var response = handler.handle(nodes);
            var notification = new ResponseReceivedNotification();
            var metadata = new HashMap<String, Object>();
            metadata.put("notification", notification.getClass());
            metadata.put("responseType", response.getType());
            var context = new Context(response.getResponse(), metadata);
            mediator.send(notification, context);
        });
        return button;
    }

    @Override
    public void receive(Context context) {
        if(isContextDataNullOrEmpty(context)) {
            nodes = Arrays.stream(context.getData().split(",")).collect(Collectors.toList());
        } else {
            System.err.println(String.format("Nodes list should not be null or empty"));
        }
    }

    @Override
    public void add(UiComponent component) {
        // Not implemented
    }
}
