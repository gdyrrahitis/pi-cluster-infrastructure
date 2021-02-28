package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RebootCommandView extends Item {
    private List<String> nodes = List.of("*");

    public RebootCommandView(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var button = new JButton("Reboot");
        button.addActionListener(e -> {
            System.out.println("Reboot button clicked. Updating nodes:");
            System.out.println(nodes);
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
