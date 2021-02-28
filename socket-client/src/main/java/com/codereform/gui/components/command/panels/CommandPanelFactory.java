package com.codereform.gui.components.command.panels;

import com.codereform.socket.client.commands.Commands;
import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.mediator.Mediator;

public class CommandPanelFactory {
    private Mediator mediator;

    public CommandPanelFactory(Mediator mediator) {
        this.mediator = mediator;
    }

    public UiComponent getCommandView(String command) {
        if (command == null) {
            return new ErrorCommandPanel(mediator,"Null command was provided");
        } else if(command.toLowerCase().equals(Commands.getShutdown())) {
            return new ShutdownCommandPanel(mediator);
        } else if (command.toLowerCase().equals(Commands.getReboot())) {
            return new RebootCommandPanel(mediator);
        }

        return null;
    }
}
