package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.CommandSelectedNotification;
import com.codereform.socket.client.commands.Commands;
import com.codereform.gui.components.communication.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class CommandListPanel extends UiComponent {
    public CommandListPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var commandListModel = new DefaultListModel<>();
        Commands.getCommands().stream().forEach(c -> commandListModel.addElement(c));
        var commandListView = new JList<>(commandListModel);
        commandListView.addListSelectionListener(evt -> {
            if(!evt.getValueIsAdjusting()) {
                var notification = new CommandSelectedNotification();
                var metadata = new HashMap<String, Object>();
                metadata.put("notification", notification.getClass());
                var context = new Context(commandListView.getSelectedValue().toString(), metadata);
                notifyColleagues(notification, context);
            }
        });

        commandListView.setBorder(emptyBorder);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(UiComponent component) { }

    private void notifyColleagues(CommandSelectedNotification notification, Context context) {
        mediator.send(notification, context);
    }
}
