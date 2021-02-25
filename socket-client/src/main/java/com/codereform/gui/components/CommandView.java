package com.codereform.gui.components;

import javax.swing.*;
import java.awt.*;

public class CommandView extends Item {
    @Override
    public Component draw() {
        var button = new JButton("Execute Command");
        return button;
    }

    @Override
    public void add(Item component) { }
}
