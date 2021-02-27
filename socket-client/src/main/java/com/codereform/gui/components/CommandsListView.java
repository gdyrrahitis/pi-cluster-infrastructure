package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Publisher;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommandsListView extends Item implements Publisher {
    private List<Subscriber> _subscribers = new ArrayList<>();

    @Override
    public Component draw() {
        var commandListModel = new DefaultListModel<>();
        commandListModel.addElement("Shutdown");
        var commandListView = new JList<>(commandListModel);
        commandListView.addListSelectionListener(evt -> {
            if(!evt.getValueIsAdjusting()) {
                var context = new Context(ListViewAction.command, commandListView.getSelectedValue().toString());
                notifySubscribers(context);
            }
        });

        commandListView.setBorder(emptyBorder);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(Item component) { }

    @Override
    public void subscribe(Subscriber subscriber) {
        _subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(Context context) {
        for (var subscriber : _subscribers) {
            subscriber.update(context);
        }
    }
}
