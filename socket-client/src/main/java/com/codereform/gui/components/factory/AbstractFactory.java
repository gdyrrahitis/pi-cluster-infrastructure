package com.codereform.gui.components.factory;

import com.codereform.gui.components.UiComponent;

public interface AbstractFactory {
    UiComponent create(Class component);
}
