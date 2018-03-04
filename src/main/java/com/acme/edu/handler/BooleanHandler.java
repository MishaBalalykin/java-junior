package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class BooleanHandler extends Handler {
    boolean flag = true;
    public BooleanHandler(Printer printer, Design design) {
        super(printer, design);
    }

    @Override
    public void perform(Object message) {
        if (flag){
            System.out.println(design.getType());
            flag = false;
        }
        System.out.println(message);
    }

    @Override
    public void flush() {

    }
}
