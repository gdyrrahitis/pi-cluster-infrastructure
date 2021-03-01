package com.codereform.socket.client.commands;

import ClusterProtos.Command;
import java.util.List;

public class ShutdownCommand extends BaseCommand {
    public ShutdownCommand() {
        super(null);
    }

    public ShutdownCommand(List<String> nodes) {
        super(nodes);
    }

    @Override
    public Command.AnsibleCommand createCommand() {
        return Command.AnsibleCommand.newBuilder()
                .setCommand(getCommand())
                .setNodes(getFormattedNodes())
                .build();
    }

    @Override
    protected String getCommand() {
        return Commands.getShutdown();
    }
}
