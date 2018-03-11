package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public interface Saver {
    void visit(Command command);
    void saveInt(String decoratedMessage);
    void saveString(String decoratedMessage);
    void saveByte(String decoratedMessage);
    void saveChar(String decoratedMessage);
    void saveBoolean(String decoratedMessage);
    void saveObject(String decoratedMessage);
    void saveArray(String decoratedMessage);
    void saveMatrix(String decoratedMessage);
    void saveOverflow(int overFlow);
}
