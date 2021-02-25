package com.codereform.gui.components;

import javax.swing.*;

public abstract class Component {
    protected JComponent _container;
    public Component() {}
    public Component(JComponent container) {
        _container = container;
    }

    public abstract Component draw();

    public abstract void add(Component component);

    public boolean isComposite() {
        return true;
    }
}
