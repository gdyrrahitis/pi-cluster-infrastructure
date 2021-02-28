package com.codereform.socket.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Nodes {
    private static final String asterisk = "*";

    public static List<String> getNodes() {
        final List<String> nodes = new ArrayList<>(Arrays.asList(
            asterisk,
            "rpizero-master",
            "rpizero-node1",
            "rpizero-node2",
            "rpizero-node3",
            "rpizero-node4",
            "rpizero-loadbalancer"
        ));
        return Collections.unmodifiableList(nodes);
    }

    public static String getAsterisk() { return asterisk; }
}
