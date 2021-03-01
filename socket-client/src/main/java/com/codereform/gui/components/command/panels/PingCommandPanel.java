package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.socket.client.commands.Commands;
import com.codereform.socket.client.sender.CommandSender;
import com.codereform.socket.client.sender.Sender;

import javax.swing.*;

public class PingCommandPanel extends ActionableCommandPanel {
    public PingCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    protected JButton getButton() {
        return new JButton("Ping");
    }

    @Override
    protected CommandSender getSender() {
        var ping = Commands.getPing();
        return new Sender(ping);
    }
}
