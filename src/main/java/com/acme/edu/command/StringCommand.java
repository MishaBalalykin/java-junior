package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class StringCommand implements Command {
    private String message;
    private String decoratedMessage;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorString(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.save(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {
        accumulator.accumulateString(message);
    }
}
