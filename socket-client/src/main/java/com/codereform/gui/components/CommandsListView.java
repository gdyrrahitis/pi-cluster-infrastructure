package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Publisher;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;

public class CommandsListView extends Item implements Publisher {
    private Subscriber _subscriber;
    private CommandView _component;

    @Override
    public Component draw() {
        var commandListModel = new DefaultListModel<>();
        commandListModel.addElement("Shutdown");
        var commandListView = new JList<>(commandListModel);
        commandListView.addPropertyChangeListener(evt -> {
            var value = (String)evt.getNewValue();
            var context = new Context(ListViewAction.command, value, _component);
            notifySubscribers(context);
        });

        commandListView.setBorder(emptyBorder);
        var scrollLayout = new JScrollPane(commandListView);
        return scrollLayout;
    }

    @Override
    public void add(Item component) { }

    @Override
    public void subscribe(Subscriber subscriber, Item component) {
        _subscriber = subscriber;
        _component = (CommandView) component;
    }

    @Override
    public void notifySubscribers(Context context) {
        _subscriber.update(context);
    }
}
