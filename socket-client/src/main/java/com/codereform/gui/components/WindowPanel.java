package com.codereform.gui.components;

import com.codereform.gui.components.command.panels.DefaultCommandPanel;
import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.CommandSelectedNotification;
import com.codereform.gui.components.communication.notifications.ResponseReceivedNotification;
import com.codereform.gui.components.factory.AbstractFactory;
import com.google.inject.Inject;

import javax.swing.*;
import java.util.List;

public class WindowPanel extends WindowBase {

    private Mediator mediator;
    private AbstractFactory factory;

    @Inject
    public WindowPanel(JFrame frame, Mediator mediator, AbstractFactory factory) {
        super(frame);
        this.mediator = mediator;
        this.factory = factory;
    }

    public void drawComponents(JFrame frame) {
        var container = factory.create(Container.class);
        var main = factory.create(MainPanel.class);
        var left = factory.create(MainPanelLeftPart.class);

        var commandsListView = factory.create(CommandListPanel.class);
        var nodesListView = factory.create(NodesListPanel.class);
        left.add(commandsListView);
        left.add(nodesListView);

        var right = factory.create(MainPanelRightPart.class);
        var commandsView = factory.create(DefaultCommandPanel.class);
        right.add(commandsView);

        main.add(left);
        main.add(right);

        var footer = factory.create(FooterPanel.class);
        var textAreaView = factory.create(TextAreaView.class);
        footer.add(textAreaView);

        container.add(main);
        container.add(footer);

        mediator.register(CommandSelectedNotification.class, List.of(right, nodesListView, textAreaView));
        mediator.register(ResponseReceivedNotification.class, textAreaView);
        container.draw();
    }
}
