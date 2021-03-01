package com.codereform.socket.client.sender;

import com.codereform.socket.client.commands.BaseCommand;
import com.codereform.socket.client.commands.RebootCommand;

import java.util.List;

public class RebootCommandSender extends CommandSender  {
    @Override
    BaseCommand getCommand(List<String> nodes) {
        return nodes == null || nodes.isEmpty() ?
                new RebootCommand():
                new RebootCommand(nodes);
    }
}
