package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public interface Accumulator {
    void visit(Command command, Saver saver);

    void accumulateInt(int message);

    void accumulateString(String message);

    void accumulateByte(byte message);

    int getIntBuffer();

    void setIntBuffer(int intBuffer);

    byte getByteBuffer();

    void setByteBuffer(byte byteBuffer);

    String getFullStr();

    void indexingStr();
}

