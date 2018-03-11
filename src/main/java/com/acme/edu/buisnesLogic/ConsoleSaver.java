package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public class ConsoleSaver implements Saver {
    /**
     * method for start accept method for current command
     *
     * @param command
     */
    @Override
    public void visit(Command command) {
        command.accept(this);
    }

    /**
     * method for consolSave
     *
     * @param decoratedMessage
     */
    @Override
    public void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    /**
     * method for save overflow
     *
     * @param overFlow
     */
    public void saveOverflow(int overFlow) {
        System.out.println(overFlow);
    }
}
