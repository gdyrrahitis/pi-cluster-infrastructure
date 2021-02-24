package com.codereform.commands;

import mymessages.Command;
import java.util.List;

public class ShutdownCommand extends BaseCommand {
    private final String _command = "shutdown";

    public ShutdownCommand() {
        super(null);
    }

    public ShutdownCommand(List<String> nodes) {
        super(nodes);
    }

    @Override
    public Command.ansibleCommand createCommand() {
        return Command.ansibleCommand.newBuilder()
                .setCommand(getCommand())
                .setNodes(getFormattedNodes())
                .build();
    }

    @Override
    protected String getCommand() {
        return _command;
    }
}
