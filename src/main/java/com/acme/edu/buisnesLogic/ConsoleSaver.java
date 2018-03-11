package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public class ConsoleSaver implements Saver {
    @Override
    public void visit(Command command) {
        command.accept(this);
    }

    @Override
    public void saveInt(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveString(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveByte(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveChar(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveBoolean(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveObject(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveArray(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    @Override
    public void saveMatrix(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }

    public void saveOverflow(int overFlow){
        System.out.println(overFlow);
    }
}
