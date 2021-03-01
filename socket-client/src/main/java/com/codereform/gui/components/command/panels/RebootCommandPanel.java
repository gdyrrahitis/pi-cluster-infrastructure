package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.socket.client.commands.Commands;
import com.codereform.socket.client.sender.CommandSender;
import com.codereform.socket.client.sender.Sender;

import javax.swing.*;

public class RebootCommandPanel extends ActionableCommandPanel {
    public RebootCommandPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    protected JButton getButton() {
        return new JButton("Reboot");
    }

    @Override
    protected CommandSender getSender() {
        var reboot = Commands.getReboot();
        return new Sender(reboot);
    }
}
