package com.acme.edu.Controller.Printer;

public class StringPrinter extends Printer {
    private final Object message;
    private final String type;

    public StringPrinter(Object messege, String type) {
        super(messege, type);
        this.message = messege;
        this.type = type;
    }
}
