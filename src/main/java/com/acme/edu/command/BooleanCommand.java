package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class BooleanCommand implements Command {
    private boolean message;
    private String decoratedMessage;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorBoolean(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveBoolean(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {

    }
}
