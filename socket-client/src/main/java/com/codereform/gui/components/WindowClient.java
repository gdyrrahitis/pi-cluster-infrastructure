package com.codereform.gui.components;

import com.codereform.gui.components.commandview.DefaultCommandView;
import com.codereform.gui.components.communication.CommandSelectedNotification;
import com.codereform.gui.components.communication.CommunicationTube;
import com.codereform.gui.components.communication.ResponseReceivedNotification;

import javax.swing.*;
import java.util.List;

public class WindowClient extends WindowBase {
    public void drawComponents(JFrame frame) {
        var mediator = new CommunicationTube();

        var container = new Container(mediator, frame);
        var main = new Main(mediator);
        var left = new MainLeftPart(mediator);

        var commandsListView = new CommandsListView(mediator);
        var nodesListView = new NodesListView(mediator, frame);
        left.add(commandsListView);
        left.add(nodesListView);

        var right = new MainRightPart(mediator, frame);
        var commandsView = new DefaultCommandView(mediator);
        right.add(commandsView);

        main.add(left);
        main.add(right);

        var footer = new Footer(mediator);
        var textAreaView = new TextAreaView(mediator);
        footer.add(textAreaView);

        container.add(main);
        container.add(footer);

        mediator.register(CommandSelectedNotification.class, List.of(right, nodesListView, textAreaView));
        mediator.register(ResponseReceivedNotification.class, textAreaView);
        container.draw();
    }
}
