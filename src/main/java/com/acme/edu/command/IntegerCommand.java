package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class IntegerCommand implements Command {
    private int message;
    private String decoratedMessage;

    public IntegerCommand(int message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorInt(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveInt(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {
        accumulator.accumulateInt(message);
    }

}
