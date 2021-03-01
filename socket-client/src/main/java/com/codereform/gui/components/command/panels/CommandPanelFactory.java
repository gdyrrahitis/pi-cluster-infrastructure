package com.codereform.gui.components.command.panels;

import com.codereform.gui.components.UiComponent;
import com.codereform.gui.components.communication.mediator.Mediator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandPanelFactory {
    private Mediator mediator;

    public CommandPanelFactory(Mediator mediator) {
        this.mediator = mediator;
    }

    public UiComponent getCommandView(String command) {
        if (command == null) {
            return new ErrorCommandPanel(mediator,"Null command was provided");
        }

        try {
            var capitalized = command.substring(0, 1).toUpperCase() + command.substring(1);
            Class<?> cmdPanelClass = Class.forName(String.format("com.codereform.gui.components.command.panels.%s%s", capitalized, "CommandPanel"));
            Constructor<?> constructor = cmdPanelClass.getConstructor(Mediator.class);
            var instance = constructor.newInstance(mediator);
            return (UiComponent) instance;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            return new ErrorCommandPanel(mediator,String.format("Could not find command panel for command %s. Error: %s", command, e.getMessage()));
        } catch (IllegalAccessException e) {
            return new ErrorCommandPanel(mediator,String.format("Could not access command panel constructor for command %s. Error: %s", command, e.getMessage()));
        } catch (InstantiationException e) {
            return new ErrorCommandPanel(mediator,String.format("Exception while instantiating command panel for command %s. Error: %s", command, e.getMessage()));
        } catch (InvocationTargetException e) {
            return new ErrorCommandPanel(mediator,String.format("Could not find command panel for command %s. Error: %s", command, e.getMessage()));
        }
    }
}
