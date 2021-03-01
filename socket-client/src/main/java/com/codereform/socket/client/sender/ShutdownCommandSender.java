package com.codereform.socket.client.sender;

import com.codereform.socket.client.commands.BaseCommand;
import com.codereform.socket.client.commands.ShutdownCommand;

import java.util.List;

public class ShutdownCommandSender extends CommandSender {
    @Override
    BaseCommand getCommand(List<String> nodes) {
        return nodes == null || nodes.isEmpty() ?
                new ShutdownCommand():
                new ShutdownCommand(nodes);
    }
}
