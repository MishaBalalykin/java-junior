package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class CharCommand implements Command {
    private char charMessage;

    public CharCommand(char message) {
        charMessage = message;
    }

    @Override
    public Command handle(Command command) {
        flush();
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {

    }

    @Override
    public void flush() {
        //printer.print("char: "+charMessage);
    }

}
