package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public interface Accumulator {
    void visit(Command command, Saver saver);
    void accumulateInt(int message);
    void accumulateString();
    void accumulateByte(byte message);

    int getIntBuffer();
    void setIntBuffer(int intBuffer);

    int getStringBuffer();
    void setStringBuffer(int stringBuffer);

    byte getByteBuffer();
    void setByteBuffer(byte byteBuffer);
}

