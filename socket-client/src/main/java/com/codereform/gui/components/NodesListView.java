package com.codereform.gui.components;

import com.codereform.custom.socket.Nodes;
import com.codereform.gui.components.communication.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NodesListView extends Item {
    private JFrame frame;
    JList<Object> listView;

    public NodesListView(Mediator mediator, JFrame frame) {
        super(mediator);

        this.frame = frame; }

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
                var context = new Context(ListViewAction.nodesUpdate, String.join(",", values));
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
    public void add(Item component) { }

    private void notifyColleagues(NodesSelectedNotification notification, Context context) {
        mediator.send(notification, context);
    }

    @Override
    public void receive(Context context) {
        if(context.getAction() == ListViewAction.command) {
            listView.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(frame, String.format("Cannot handle '%s' action in %s.", context.getAction(), this.getClass().getName()));
        }
    }
}
