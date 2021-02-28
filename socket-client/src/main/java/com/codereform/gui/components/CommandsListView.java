package com.codereform.gui.components;

import com.codereform.commands.Commands;
import com.codereform.gui.components.communication.*;

import javax.swing.*;
import java.awt.*;

public class CommandsListView extends Item {
    public CommandsListView(Mediator mediator) {
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
                var context = new Context(ListViewAction.command, commandListView.getSelectedValue().toString());
                notifyColleagues(notification, context);
            }
        });

        commandListView.setBorder(emptyBorder);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(Item component) { }

    private void notifyColleagues(CommandSelectedNotification notification, Context context) {
        mediator.send(notification, context);
    }
}
