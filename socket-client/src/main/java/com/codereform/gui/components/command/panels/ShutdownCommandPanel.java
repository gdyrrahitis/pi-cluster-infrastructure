package com.codereform.gui.components.command.panels;

import com.codereform.socket.client.commands.Commands;
import com.codereform.socket.client.sender.CommandSender;
import com.codereform.socket.client.sender.Sender;
import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;

public class ShutdownCommandPanel extends ActionableCommandPanel {
    public ShutdownCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    protected JButton getButton() {
        return new JButton("Shutdown");
    }

    @Override
    protected CommandSender getSender() {
        var shutdown = Commands.getShutdown();
        return new Sender(shutdown);
    }
}
