package com.codereform.gui.components;

import com.codereform.gui.components.commandview.CommandFactory;
import com.codereform.gui.components.communication.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainRightPart extends Item {
    private final CommandFactory commandFactory;
    private List<Item> _components = new ArrayList<>();
    private JPanel commandPanel = new JPanel();
    private JFrame frame;
    private String currentCommand;

    public MainRightPart(Mediator mediator, JFrame frame) {
        super(mediator);

        this.frame = frame;
        commandFactory = new CommandFactory(mediator);
    }

    @Override
    public Component draw() {
        var mainBoxLayout = new BoxLayout(commandPanel, BoxLayout.Y_AXIS);
        commandPanel.setLayout(mainBoxLayout);
        commandPanel.setBorder(emptyBorder);
        _components.stream().map(Item::draw).forEach(commandPanel::add);
        return commandPanel;
    }

    @Override
    public void add(Item component) {
        _components.add(component);
    }

    @Override
    public void receive(Context context) {
        if(context.getAction() == ListViewAction.command) {
            var command = context.getData();
            if (currentCommand == null || currentCommand.trim().isEmpty()) {
                currentCommand = command;
            } else if (currentCommand.equals(command)) {
                JOptionPane.showMessageDialog(frame, String.format("Command '%s' is already selected", command));
                return;
            } else {
                currentCommand = command;
            }

            commandPanel.removeAll();
            var view = commandFactory.getCommandView(command);
            mediator.registerOrReplace(NodesSelectedNotification.class, view);
            var result = view.draw();
            commandPanel.add(result);
            frame.invalidate();
            frame.validate();
            frame.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, String.format("Cannot handle '%s' action. %s", context.getAction(), this.getClass().getName()));
        }
    }
}
