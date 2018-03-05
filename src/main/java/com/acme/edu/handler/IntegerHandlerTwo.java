package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class IntegerHandlerTwo extends IntegerHandler {

    public IntegerHandlerTwo(Printer printer, Design design) {
        super(printer, design);
    }

    @Override
    public void perform(Object message){
        System.out.println("override");
    }
}
