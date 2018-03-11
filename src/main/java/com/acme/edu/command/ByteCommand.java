package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class ByteCommand implements Command {
    private byte message;
    private String decoratedMessage;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorByte(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveByte(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {
        accumulator.accumulateByte(message);
    }
}
