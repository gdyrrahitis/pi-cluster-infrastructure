package com.codereform.custom.socket;

import com.codereform.commands.ICommand;
import com.codereform.commands.ShutdownCommand;

import java.util.List;

public class ShutdownCommandHandler extends CommandHandler {

    @Override
    ICommand getCommand(List<String> nodes) {
        return nodes == null || nodes.isEmpty() ?
                new ShutdownCommand():
                new ShutdownCommand(nodes);
    }
}
