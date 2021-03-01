package com.codereform.socket.client.commands;

import ClusterProtos.Command;
import com.codereform.socket.client.Nodes;

import java.util.List;
import java.util.stream.Collectors;

public class CommandBuilder {
    protected String getFormattedNodes(List<String> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return Nodes.getAsterisk();
        } else {
            return nodes.stream().collect(Collectors.joining(","));
        }
    }

    public ProtoCommand createCommand(String command, List<String> nodes) {
        var proto = Command.AnsibleCommand.newBuilder()
                .setCommand(command)
                .setNodes(getFormattedNodes(nodes))
                .build();
        return new ProtoCommand(proto);
    }
}
