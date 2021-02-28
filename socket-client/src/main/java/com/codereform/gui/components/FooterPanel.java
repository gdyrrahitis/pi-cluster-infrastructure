package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FooterPanel extends UiComponent {
    private List<UiComponent> _components = new ArrayList<>();

    public FooterPanel(Mediator mediator) {
        super(mediator);
    }

    @Override
    public Component draw() {
        var footer = new JPanel();
        var boxLayout2 = new BoxLayout(footer, BoxLayout.Y_AXIS);
        footer.setLayout(boxLayout2);
        _components.stream().map(UiComponent::draw).forEach(footer::add);
        return footer;
    }

    @Override
    public void add(UiComponent component) {
        _components.add(component);
    }
}
