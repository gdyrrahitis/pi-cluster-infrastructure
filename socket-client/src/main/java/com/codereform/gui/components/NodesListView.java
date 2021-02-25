package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Publisher;
import com.codereform.gui.components.communication.Subscriber;

import javax.swing.*;
import java.awt.*;

public class NodesListView extends Item implements Publisher {
    private Subscriber _subscriber;
    private CommandView _component;

    @Override
    public Component draw() {
        var listModel = new DefaultListModel<>();
        // TODO: Retrieve from configuration or Constants
        listModel.addElement("*");
        listModel.addElement("rpizero-master");
        listModel.addElement("rpizero-node1");
        listModel.addElement("rpizero-node2");
        listModel.addElement("rpizero-node3");
        listModel.addElement("rpizero-node4");
        listModel.addElement("rpizero-loadbalancer");
        var listView = new JList<>(listModel);
        listView.setSelectedIndex(0);
        listView.setBorder(emptyBorder);
        listView.addPropertyChangeListener(evt -> {
            // TODO: Update for multiple selection
            var value = (String)evt.getNewValue();
            var context = new Context(ListViewAction.nodesUpdate, value, _component);
            notifySubscribers(context);
        });
        return listView;
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
