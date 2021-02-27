package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;

import javax.swing.*;
import java.awt.*;

public class DefaultCommandView extends Item {
    @Override
    public Component draw() {
        var label = new JLabel("Select a command from the pane on the right");
        return label;
    }

    @Override
    public void add(Item component) { }
}
