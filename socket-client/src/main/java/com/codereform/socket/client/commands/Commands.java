package com.codereform.socket.client.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Commands {
    private static final String shutdown = "shutdown";
    private static final String reboot = "reboot";
    private static final String ping = "ping";

    public static List<String> getCommands() {
        final List<String> commands = new ArrayList<>(Arrays.asList(
                shutdown,
                reboot,
                ping
        ));
        return Collections.unmodifiableList(commands);
    }

    public static String getShutdown() {return shutdown;}
    public static String getReboot() {return reboot;}
    public static String getPing() {return ping;}
}
