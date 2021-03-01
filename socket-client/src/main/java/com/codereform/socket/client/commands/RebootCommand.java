package com.codereform.socket.client.commands;

import ClusterProtos.Command;

import java.util.List;

public class RebootCommand extends BaseCommand {
    public RebootCommand() {
        super(null);
    }

    public RebootCommand(List<String> nodes) {
        super(nodes);
    }

    @Override
    protected String getCommand() {
        return Commands.getReboot();
    }

    @Override
    public Command.AnsibleCommand createCommand() {
        return Command.AnsibleCommand.newBuilder()
                .setCommand(getCommand())
                .setNodes(getFormattedNodes())
                .build();
    }
}
