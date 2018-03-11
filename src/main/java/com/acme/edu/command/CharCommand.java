package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class CharCommand implements Command {
    private char message;
    private String decoratedMessage;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorChar(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.save(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {

    }
}
