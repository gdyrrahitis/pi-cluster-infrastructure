package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;

import javax.swing.*;
import java.awt.*;

public class ShutdownCommandView extends Item {
    @Override
    public Component draw() {
        var button = new JButton("Shutdown");
        return button;
    }

    @Override
    public void add(Item component) {

    }
}
