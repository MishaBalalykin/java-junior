package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class ObjectCommand implements Command {
    private Object message;
    private String decoratedMessage;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorObject(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveObject(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {

    }
}
