package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class MatrixCommand implements Command {
    private int[][] message;
    private String decoratedMessage;

    public MatrixCommand(int[][] message) {
        this.message = message;
    }

    @Override
    public void accept(Decorator decorator) {
        decoratedMessage = decorator.decorMatrix(message);
    }

    @Override
    public void accept(Saver saver) {
        saver.saveMatrix(decoratedMessage);
    }

    @Override
    public void accept(Accumulator accumulator) {
        return;
    }
}
