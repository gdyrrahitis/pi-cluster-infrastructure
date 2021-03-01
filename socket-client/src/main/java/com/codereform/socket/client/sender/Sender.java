package com.codereform.socket.client.sender;

import com.codereform.socket.client.commands.CommandBuilder;
import com.codereform.socket.client.commands.ProtoCommand;

import java.util.List;

public class Sender extends CommandSender {
    private String commandName;

    public Sender(String commandName) {
        this.commandName = commandName;
    }

    @Override
    ProtoCommand getCommand(List<String> nodes) {
        var commandBuilder = new CommandBuilder();
        var proto = commandBuilder.createCommand(commandName, nodes);
        return proto;
    }
}
