package com.codereform.socket.client.sender;

import com.codereform.socket.client.commands.ICommand;
import com.codereform.socket.client.commands.ShutdownCommand;

import java.util.List;

public class ShutdownCommandSender extends CommandSender {

    @Override
    ICommand getCommand(List<String> nodes) {
        return nodes == null || nodes.isEmpty() ?
                new ShutdownCommand():
                new ShutdownCommand(nodes);
    }
}
