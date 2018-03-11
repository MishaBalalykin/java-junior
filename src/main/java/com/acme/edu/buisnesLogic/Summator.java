package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public class Summator implements Accumulator {
    private int intBuffer = 0;
    private byte byteBuffer = 0;
    private int stringBuffer = 0;
    private Saver saver;

    @Override
    public void visit(Command command, Saver saver) {
        this.saver = saver;
        command.accept(this);
    }
    @Override
    public void accumulateInt(int message) {
        stringBuffer = 0;
        accumulator(message);
    }

    @Override
    public void accumulateString() {
        intBuffer = 0;
        stringBuffer++;
    }

    @Override
    public void accumulateByte(byte message) {
        stringBuffer = 0;
        accumulator(message);
    }

    private void accumulator(int intMessage) {
        if(!checkOwerflow(intMessage)){
            intBuffer += intMessage;
        }
    }

    private void accumulator(byte byteMessage) {
        if(!checkOwerflow(byteMessage)){
            byteBuffer += byteMessage;
        }
    }

    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - intBuffer;
        if (intMessage > delta) {
            intBuffer = Integer.MAX_VALUE;
            flush(intBuffer);
            intBuffer = intMessage - delta;
            return  true;
        }
        return false;
    }

    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - byteBuffer);
        if (byteMessage > delta) {
            byteBuffer = Byte.MAX_VALUE;
            flush(byteBuffer);
            byteBuffer = (byte) (byteMessage - delta);
            return  true;
        }
        return false;
    }

    public void flush(int buffer) {
        saver.saveOverflow(buffer);
    }


    @Override
    public int getIntBuffer() {
        return intBuffer;
    }

    @Override
    public void setIntBuffer(int intBuffer) {
        this.intBuffer = intBuffer;
    }

    @Override
    public int getStringBuffer() {
        return stringBuffer;
    }

    @Override
    public void setStringBuffer(int stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    @Override
    public byte getByteBuffer() {
        return byteBuffer;
    }

    @Override
    public void setByteBuffer(byte byteBuffer) {
        this.byteBuffer = byteBuffer;
    }
}
