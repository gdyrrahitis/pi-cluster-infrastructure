package com.codereform.custom.socket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Nodes {
    public static List<String> getNodes() {
        final List<String> nodes = new ArrayList<>(Arrays.asList(
            "*",
            "rpizero-master",
            "rpizero-node1",
            "rpizero-node2",
            "rpizero-node3",
            "rpizero-node4",
            "rpizero-loadbalancer"
        ));
        return Collections.unmodifiableList(nodes);
    }
}
