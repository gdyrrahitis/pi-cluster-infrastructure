package com.codereform.gui.components.factory;

import com.codereform.gui.components.UiComponent;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class ComponentFactory implements AbstractFactory {
    private Injector injector;

    @Inject
    public ComponentFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public UiComponent create(Class component) {
        return injector.getInstance(Key.get(UiComponent.class, Names.named(component.getName())));
    }
}
