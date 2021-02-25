package com.codereform.gui.components.communication;

import com.codereform.gui.components.Item;

public class Context {
    public String commandName;
    private ListViewAction action;
    public Item component;

    public Context(ListViewAction action, String commandName, Item component) {
        this.action = action;
        this.component = component;
        this.commandName = commandName;
    }

    public String getCommandName() {return commandName;}
    public Item getComponent() { return component; }
}
