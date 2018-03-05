package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.disign.DesignInteger;
import com.acme.edu.printer.Printer;

/**
 * @author MishaAndEugen
 * класс Рandler отвечает за добавление новых типов с помощью полиморфизма
 */
public interface Handler {

    void perform();
    void flush();
}
