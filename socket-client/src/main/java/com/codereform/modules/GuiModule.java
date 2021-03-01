package com.codereform.modules;

import com.codereform.gui.components.*;
import com.codereform.gui.components.command.panels.DefaultCommandPanel;
import com.codereform.gui.components.communication.mediator.CommunicationTube;
import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.factory.AbstractFactory;
import com.codereform.gui.components.factory.ComponentFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

import javax.swing.*;

public class GuiModule extends AbstractModule {
    private static final String title = "Raspberry Pi Cluster Manager";

    @Override
    protected void configure() {
        bind(WindowBase.class).to(WindowPanel.class);
        bind(Mediator.class).to(CommunicationTube.class).in(Singleton.class);
        bind(AbstractFactory.class).to(ComponentFactory.class);

        bind(UiComponent.class).annotatedWith(Names.named(Container.class.getName())).to(Container.class);
        bind(UiComponent.class).annotatedWith(Names.named(MainPanel.class.getName())).to(MainPanel.class);
        bind(UiComponent.class).annotatedWith(Names.named(NodesListPanel.class.getName())).to(NodesListPanel.class);
        bind(UiComponent.class).annotatedWith(Names.named(CommandListPanel.class.getName())).to(CommandListPanel.class);
        bind(UiComponent.class).annotatedWith(Names.named(FooterPanel.class.getName())).to(FooterPanel.class);
        bind(UiComponent.class).annotatedWith(Names.named(MainPanelRightPart.class.getName())).to(MainPanelRightPart.class);
        bind(UiComponent.class).annotatedWith(Names.named(MainPanelLeftPart.class.getName())).to(MainPanelLeftPart.class);
        bind(UiComponent.class).annotatedWith(Names.named(DefaultCommandPanel.class.getName())).to(DefaultCommandPanel.class);
        bind(UiComponent.class).annotatedWith(Names.named(TextAreaView.class.getName())).to(TextAreaView.class);
    }

    @Provides
    @Singleton
    static JFrame provideJFrame() {
        var frame = new JFrame(title);
        return frame;
    }
}
