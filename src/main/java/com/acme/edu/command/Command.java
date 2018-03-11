package com.acme.edu.command;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;

public interface Command {
    void accept(Decorator decorator);
    void accept(Saver saver);
    void accept(Accumulator accumulator);
    //int flush(int accumulator);
}
