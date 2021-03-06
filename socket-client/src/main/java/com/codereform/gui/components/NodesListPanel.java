package com.codereform.gui.components;

import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.NodesSelectedNotification;
import com.codereform.socket.client.Nodes;
import com.codereform.gui.components.communication.*;
import com.google.inject.Inject;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NodesListPanel extends UiComponent {
    private JFrame frame;
    private JList<Object> listView;

    @Inject
    public NodesListPanel(Mediator mediator, JFrame frame) {
        super(mediator);
        this.frame = frame;
    }

    @Override
    public Component draw() {
        var listModel = new DefaultListModel<>();
        Nodes.getNodes().stream().forEach(n -> listModel.addElement(n));
        listView = new JList<>(listModel);
        listView.setSelectedIndex(0);
        listView.setBorder(emptyBorder);
        listView.addListSelectionListener(evt -> {
            if(!evt.getValueIsAdjusting()) {
                var selectedValues = listView.getSelectedValuesList();
                var values = (isMultiSelectWithAsteriskInValues(selectedValues)) ?
                        getSelectedValuesWithAsteriskExcluded(selectedValues): toStringList(selectedValues);

                var notification = new NodesSelectedNotification();
                var context = new Context(String.join(",", values));
                notifyColleagues(notification, context);
            }
        });
        var scrollLayout = new JScrollPane(listView);
        return scrollLayout;
    }

    private boolean isMultiSelectWithAsteriskInValues(List<Object> selectedValues) {
        return isItMultiSelect(selectedValues) && doesAsteriskExistInValues(selectedValues);
    }

    private boolean isItMultiSelect(List<Object> selectedValues) {
        return selectedValues.size() > 1;
    }

    private boolean doesAsteriskExistInValues(List<Object> selectedValues) {
        return getStringValues(selectedValues).anyMatch(x -> x.equals(Nodes.getAsterisk()));
    }

    private Stream<String> getStringValues(List<Object> selectedValues) {
        return selectedValues.stream().map(Object::toString);
    }

    private List<String> getSelectedValuesWithAsteriskExcluded(List<Object> selectedValues) {
        return getStringValues(selectedValues).filter(x -> !x.equals(Nodes.getAsterisk())).collect(Collectors.toList());
    }

    private List<String> toStringList(List<Object> selectedValues) {
        return getStringValues(selectedValues).collect(Collectors.toList());
    }

    @Override
    public void add(UiComponent component) { }

    private void notifyColleagues(NodesSelectedNotification notification, Context context) {
        mediator.send(notification, context);
    }

    @Override
    public void receive(Context context) {
        listView.setSelectedIndex(0);
    }
}
