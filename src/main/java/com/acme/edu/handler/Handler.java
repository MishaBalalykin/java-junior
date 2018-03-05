package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.disign.DesignInteger;
import com.acme.edu.printer.Printer;

/**
 * @author MishaAndEugen
 * класс Рandler отвечает за добавление новых типов с помощью полиморфизма
 */
public abstract class Handler {
    protected Printer printer;
    protected Design design;

    public Handler(Printer printer, Design design) {
        this.printer = printer;
        this.design = design;
    }

    public abstract void perform(Object message);
    public abstract void flush();
}
