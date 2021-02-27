package com.codereform.gui.components.commandview;

import com.codereform.gui.components.Item;

import javax.swing.*;
import java.awt.*;

public class RebootCommandView extends Item {
    @Override
    public Component draw() {
        var button = new JButton("Reboot");
        return button;
    }

    @Override
    public void add(Item component) {

    }
}
