package com.codereform.gui.components.communication;

public class Context {
    private String data;
    private ListViewAction action;

    public Context(ListViewAction action, String data) {
        this.action = action;
        this.data = data;
    }

    public String getData() { return data; }

    public ListViewAction getAction() { return action; }

    public void setAction(ListViewAction action) { this.action = action; }
}
