package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class DefaultCommand implements Command {
    @Override
    public Command handle(Command command) {
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {

    }

    @Override
    public void flush() {

    }
}
