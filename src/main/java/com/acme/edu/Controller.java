package com.acme.edu;

import com.acme.edu.buisnesLogic.Accumulator;
import com.acme.edu.buisnesLogic.Decorator;
import com.acme.edu.buisnesLogic.Saver;
import com.acme.edu.command.Command;
import com.acme.edu.command.NullCommand;

public class Controller {
    private Command command;

    public Controller(Command command) {
        this.command = command;
    }

    protected void execute(Decorator decorator, Saver saver, Accumulator accumulator) {
        //region executeVisit
        accumulator.visit(command, saver);
        decorator.visit(command, accumulator);
        saver.visit(command);
        //endregion
    }

}
