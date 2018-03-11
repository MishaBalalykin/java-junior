package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public interface Decorator {
    void visit(Command command, Accumulator accumulator);
    String decorInt(int message);
    String decorString(String message);
    String decorByte(byte message);
    String decorChar(char message);
    String decorBoolean(boolean message);
    String decorObject(Object message);
    String decorArray(int[] message);
    String decorMatrix(int[][] message);
}
