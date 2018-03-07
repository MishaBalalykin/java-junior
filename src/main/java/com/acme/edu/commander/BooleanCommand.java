package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class BooleanCommand implements Command {
    private boolean booleanMessage;
    private Printer printer;

    public BooleanCommand(boolean message) {
        booleanMessage = message;
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
        //printer.print("primitive: "+booleanMessage);
    }

    @Override
    public boolean isFlush() {
        return false;
    }
}
