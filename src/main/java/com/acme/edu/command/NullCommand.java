package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public class NullCommand implements Command {
    @Override
    public void accept(Decorator decorator) {

    }

    @Override
    public void accept(Saver saver) {

    }

    @Override
    public void accept(Accumulator accumulator) {

    }
}
