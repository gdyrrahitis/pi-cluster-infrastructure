package com.codereform.socket.client.commands;

import mymessages.Command;
import java.util.List;

public class ShutdownCommand extends BaseCommand {
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
        return Commands.getShutdown();
    }
}
