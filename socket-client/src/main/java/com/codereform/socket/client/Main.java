package com.codereform.socket.client;

import com.codereform.gui.components.WindowBase;
import com.codereform.modules.GuiModule;
import com.google.inject.Guice;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var injector = Guice.createInjector(new GuiModule());
            var window = injector.getInstance(WindowBase.class);
            window.draw();
        });
    }
}
