package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public class Summator implements Accumulator {
    //region initialize
    private int intBuffer = 0;
    private byte byteBuffer = 0;
    private int stringBuffer = 0;
    private String lastStr = "";
    private String fullStr = "";
    private Saver saver;
    //endregion

    /**
     * @param command
     * @param saver
     * @author Misha
     * method for initialize saver and start accept method
     */
    @Override
    public void visit(Command command, Saver saver) {
        this.saver = saver;
        command.accept(this);
    }

    /**
     * @param message
     * @author Misha
     * method for flush stringBuffer and start accumulator method
     */
    @Override
    public void accumulateInt(int message) {
        stringBuffer = 0;
        accumulator(message);
    }

    /**
     * @param message
     * @author Misha
     * method for flush intBuffer and start buildStr method
     */
    @Override
    public void accumulateString(String message) {
        intBuffer = 0;
        buildStr(message);
    }

    /**
     * @param message
     * @author Misha
     * method for flush stringBuffer and start accumulator method
     */
    @Override
    public void accumulateByte(byte message) {
        stringBuffer = 0;
        accumulator(message);
    }

    /**
     * @param intMessage
     * @author Misha
     * method for accumulate intBuffer if checkOwerflow return false
     */
    private void accumulator(int intMessage) {
        if (!checkOwerflow(intMessage)) {
            intBuffer += intMessage;
        }
    }

    /**
     * @param byteMessage
     * @author Misha
     * method for accumulate intBuffer if checkOwerflow return false
     */
    private void accumulator(byte byteMessage) {
        if (!checkOwerflow(byteMessage)) {
            byteBuffer += byteMessage;
        }
    }

    /**
     * @param intMessage
     * @author Misha
     * method for check Owerflow for int
     */
    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - intBuffer;
        if (intMessage > delta) {
            intBuffer = Integer.MAX_VALUE;
            flush(intBuffer);
            intBuffer = intMessage - delta;
            return true;
        }
        return false;
    }

    /**
     * @param byteMessage
     * @author Misha
     * method for check Owerflow for byte
     */
    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - byteBuffer);
        if (byteMessage > delta) {
            byteBuffer = Byte.MAX_VALUE;
            flush(byteBuffer);
            byteBuffer = (byte) (byteMessage - delta);
            return true;
        }
        return false;
    }

    /**
     * @param stringMessage
     * @author Misha
     * method for accumulate strings if they are equals
     * and start indexingStr if not
     */
    private void buildStr(String stringMessage) {
        if (stringMessage.equals(lastStr)) {
            stringBuffer++;
        } else {
            indexingStr();
            fullStr += stringMessage + "\n";
        }
        lastStr = stringMessage;
    }

    /**
     * @author Misha
     * method for check if stringBuffer > 0 and if it's true start deleteLastSymStr
     * and build prefix
     */
    @Override
    public void indexingStr() {
        if (stringBuffer > 0) {
            deleteLastSymStr();
            fullStr += " (x" + (stringBuffer + 1) + ")\n";
            saver.save(fullStr);
            stringBuffer = 0;
        }
    }

    /**
     * method for del \r\n
     */
    private void deleteLastSymStr() {
        if (!fullStr.equals("")) {
            StringBuilder stringBuilder = new StringBuilder(fullStr);
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            fullStr = stringBuilder.toString();
        }
    }

    /**
     * method for print overflow
     *
     * @param buffer
     */
    public void flush(int buffer) {
        saver.saveOverflow(buffer);
    }


    /**
     * getters and setters
     *
     * @return
     */
    @Override
    public int getIntBuffer() {
        return intBuffer;
    }

    @Override
    public void setIntBuffer(int intBuffer) {
        this.intBuffer = intBuffer;
    }

    @Override
    public byte getByteBuffer() {
        return byteBuffer;
    }

    @Override
    public void setByteBuffer(byte byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public String getFullStr() {
        return fullStr;
    }
}
