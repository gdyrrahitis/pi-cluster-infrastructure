package com.codereform.gui.components;

import javax.swing.*;

public class WindowClient extends WindowBase {
    public void drawComponents(JFrame frame) {
        var container = new Container(frame);
        var main = new Main();
        var left = new MainLeftPart();

        var commandsListView = new CommandsListView(); // publisher
        var nodesListView = new NodesListView();
        left.add(commandsListView);
        left.add(nodesListView);

        var right = new MainRightPart(); // subscriber -- has reference to JFrame
        var commandsView = new CommandView();
        // commandsListView.subscribe(right, commandsView)
        // update(context)
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
