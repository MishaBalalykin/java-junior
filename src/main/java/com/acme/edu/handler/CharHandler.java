package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class CharHandler extends Handler {
    boolean flag = true;
    public CharHandler(Printer printer, Design design) {
        super(printer, design);
    }

    @Override
    public void perform(Object message) {
        if (flag){
            flush();
            flag = false;
        }
        printer.print(message.toString());
    }

    @Override
    public void flush() {
        System.out.println(design.getType());
    }
}
