package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.ListViewAction;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RebootCommandPanel extends UiComponent {
    private List<String> nodes = List.of("*");

    public RebootCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var button = new JButton("Reboot");
        button.addActionListener(e -> {
            // TODO: Implement
            System.out.println("Reboot button clicked. Updating nodes:");
            System.out.println(nodes);
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
