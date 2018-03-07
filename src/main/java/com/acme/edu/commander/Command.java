package com.acme.edu.commander;


import com.acme.edu.formatter.FormatVisitor; /**
 * @author MishaAndEugen
 * класс Рandler отвечает за добавление новых типов с помощью полиморфизма
 */
public interface Command {
    Command handle(Command command);
    void accept(FormatVisitor formatVisitor);
    void flush();
    String toString();
    boolean isFlush();
}
