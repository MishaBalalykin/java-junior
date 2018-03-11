package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class ArrayCommand implements Command {
    private int[] message;
    private String decoratedMessage;

    public ArrayCommand(int[] message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorArray(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveArray(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {
        return;
    }
}
