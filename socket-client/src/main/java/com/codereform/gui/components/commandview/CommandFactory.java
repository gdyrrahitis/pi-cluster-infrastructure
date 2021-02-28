package com.codereform.gui.components.commandview;

import com.codereform.commands.Commands;
import com.codereform.gui.components.Item;
import com.codereform.gui.components.communication.Mediator;

public class CommandFactory {
    private Mediator mediator;

    public CommandFactory(Mediator mediator) {

        this.mediator = mediator;
    }

    public Item getCommandView(String command) {
        if (command == null) {
            return new ErrorCommandView(mediator,"Null command was provided");
        } else if(command.toLowerCase().equals(Commands.getShutdown())) {
            return new ShutdownCommandView(mediator);
        } else if (command.toLowerCase().equals(Commands.getReboot())) {
            return new RebootCommandView(mediator);
        }

        return null;
    }
}
