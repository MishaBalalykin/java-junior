package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class ObjectCommand implements Command {
    private Object objectMessage;

    public ObjectCommand(Object message) {
        objectMessage = message;
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
        //printer.print("reference: "+objectMessage);
    }

    @Override
    public boolean isFlush() {
        return false;
    }

}
