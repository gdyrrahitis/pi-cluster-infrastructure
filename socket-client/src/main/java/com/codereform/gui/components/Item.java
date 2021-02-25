package com.codereform.gui.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class Item {
    protected final Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    public abstract Component draw();
    public abstract void add(Item component);
}
