package com.codereform.socket.client.commands;

import com.codereform.socket.client.Nodes;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCommand implements ICommand {
    protected List<String> _nodes;
    protected BaseCommand(List<String> nodes) {
        _nodes = nodes;
    }

    protected List<String> getNodes() {
        return _nodes;
    }

    protected abstract String getCommand();

    protected String getFormattedNodes() {
        var nodes = getNodes();
        if (nodes == null || nodes.isEmpty()) {
            return Nodes.getAsterisk();
        } else {
            return nodes.stream().collect(Collectors.joining(","));
        }
    }
}
