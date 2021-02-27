package com.codereform.gui.components;

import com.codereform.gui.components.commandview.DefaultCommandView;

import javax.swing.*;

public class WindowClient extends WindowBase {
    public void drawComponents(JFrame frame) {
        var container = new Container(frame);
        var main = new Main();
        var left = new MainLeftPart();

        var commandsListView = new CommandsListView();
        var nodesListView = new NodesListView(frame);
        left.add(commandsListView);
        left.add(nodesListView);

        var right = new MainRightPart(frame);
        var commandsView = new DefaultCommandView();
        commandsListView.subscribe(right);
        nodesListView.subscribe(right);
        commandsListView.subscribe(nodesListView);
        right.add(commandsView);

        main.add(left);
        main.add(right);

        var footer = new Footer();
        var textAreaView = new TextAreaView();
        commandsListView.subscribe(textAreaView);
        footer.add(textAreaView);

        container.add(main);
        container.add(footer);
        container.draw();
    }
}
