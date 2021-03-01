package com.codereform.socket.client.commands;

import ClusterProtos.Command;

public class ProtoCommand {
    private Command.AnsibleCommand command;

    public ProtoCommand(Command.AnsibleCommand command) {
        this.command = command;
    }

    public Command.AnsibleCommand getCommand() { return command; }
}
