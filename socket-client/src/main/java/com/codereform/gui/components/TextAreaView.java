package com.codereform.gui.components;

import com.codereform.gui.components.communication.Context;
import com.codereform.gui.components.communication.mediator.Mediator;
import com.codereform.gui.components.communication.notifications.CommandSelectedNotification;
import com.codereform.gui.components.communication.notifications.ResponseReceivedNotification;
import com.codereform.socket.client.response.ResponseType;
import com.google.inject.Inject;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class TextAreaView extends UiComponent {
    private final Insets margin = new Insets(10, 10, 10, 10);
    private final TextStyler styler;
    private JTextPane textArea = new JTextPane();

    @Inject
    public TextAreaView(Mediator mediator) {
        super(mediator);
        styler = new TextStyler(textArea);
    }

    @Override
    public Component draw() {
        textArea.setEditable(false);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textArea.setMargin(margin);
        styler.setColor(Color.black);
        return textArea;
    }

    @Override
    public void add(UiComponent component) { }

    public void receive(Context context) {
        var notificationType = (Class)context.getMetadataValueByKey("notification");
        if(notificationType == ResponseReceivedNotification.class) {
            var responseType = (ResponseType)context.getMetadataValueByKey("responseType");
            switch (responseType) {
                case success:
                    styler.setColor(Color.green);
                    break;
                case error:
                case exception:
                    styler.setColor(Color.red);
                    break;
            }
            textArea.setText(context.getData());
        } else if(notificationType == CommandSelectedNotification.class) {
            styler.setColor(Color.black);
            textArea.setText("");
        }
    }

    class TextStyler {
        private JTextPane component;

        public TextStyler(JTextPane component) {
            this.component = component;
        }

        public void setColor(Color color) {
            var sc = StyleContext.getDefaultStyleContext();
            var attr = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
            component.setCharacterAttributes(attr, false);
        }
    }
}
