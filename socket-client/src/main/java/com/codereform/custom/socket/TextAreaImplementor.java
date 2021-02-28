package com.codereform.custom.socket;

import javax.swing.*;

public class TextAreaImplementor extends ResponseImplementor {
    private JTextArea textArea;

    public TextAreaImplementor(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void handleResponse(String response) {
        textArea.setText(response);
    }
}
