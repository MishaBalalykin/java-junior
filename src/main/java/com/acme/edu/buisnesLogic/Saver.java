package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public interface Saver {
    void visit(Command command);

    void save(String decoratedMessage);

    void saveOverflow(int overFlow);
}
