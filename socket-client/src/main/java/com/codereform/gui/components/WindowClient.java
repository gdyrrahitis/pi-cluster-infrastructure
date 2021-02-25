package com.codereform.gui.components;

import javax.swing.*;

public class WindowClient extends WindowBase {
    public void drawComponents(JFrame frame) {
        var container = new Container(frame);
        var main = new Main();
        var left = new MainLeftPart();

        var commandsListView = new CommandsListView();
        var nodesListView = new NodesListView();
        left.add(commandsListView);
        left.add(nodesListView);

        var right = new MainRightPart();
        var commandsView = new CommandView();
        right.add(commandsView);

        main.add(left);
        main.add(right);

        var footer = new Footer();
        var textAreaView = new TextAreaView();
        footer.add(textAreaView);

        container.add(main);
        container.add(footer);
        container.draw();
    }
}
