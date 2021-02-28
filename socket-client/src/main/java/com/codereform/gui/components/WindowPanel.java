package com.codereform.gui.components;

import com.codereform.gui.components.command.panels.DefaultCommandPanel;
import com.codereform.gui.components.communication.notifications.CommandSelectedNotification;
import com.codereform.gui.components.communication.mediator.CommunicationTube;
import com.codereform.gui.components.communication.notifications.ResponseReceivedNotification;

import javax.swing.*;
import java.util.List;

public class WindowPanel extends WindowBase {
    public void drawComponents(JFrame frame) {
        var mediator = new CommunicationTube();

        var container = new Container(mediator, frame);
        var main = new MainPanel(mediator);
        var left = new MainPanelLeftPart(mediator);

        var commandsListView = new CommandListPanel(mediator);
        var nodesListView = new NodesListPanel(mediator, frame);
        left.add(commandsListView);
        left.add(nodesListView);

        var right = new MainPanelRightPart(mediator, frame);
        var commandsView = new DefaultCommandPanel(mediator);
        right.add(commandsView);

        main.add(left);
        main.add(right);

        var footer = new FooterPanel(mediator);
        var textAreaView = new TextAreaView(mediator);
        footer.add(textAreaView);

        container.add(main);
        container.add(footer);

        mediator.register(CommandSelectedNotification.class, List.of(right, nodesListView, textAreaView));
        mediator.register(ResponseReceivedNotification.class, textAreaView);
        container.draw();
    }
}
