package com.codereform.gui.components.commandview;

import com.codereform.commands.Commands;
import com.codereform.gui.components.Item;

public class CommandFactory {
    public Item getCommandView(String command) {
        if (command == null) {
            return new ErrorCommandView("Null command was provided");
        } else if(command.toLowerCase().equals(Commands.getShutdown())) {
            return new ShutdownCommandView();
        } else if (command.toLowerCase().equals(Commands.getReboot())) {
            return new RebootCommandView();
        }

        return null;
    }
}
