package com.acme.edu.buisnesLogic;

import com.acme.edu.command.Command;

public class PrefixDecorator implements Decorator {
    //region initialize
    private final String PRIMITIVE = "primitive: "+ "\r\n";
    private final String CHAR = "char: "+ "\r\n";
    private final String STRING = "string: "+ "\r\n";
    private final String REFERENCE = "reference: "+ "\r\n";
    private final String PRIMITIVE_ARRAY = "primitives array: {";
    private final String PRIMITIVE_MATRIX = "primitives matrix: {" + "\r\n";
    private Accumulator accumulator;
    //endregion

    /**
     * method for set accumulator and start accept method for current command
     *
     * @param command
     * @param accumulator
     */
    @Override
    public void visit(Command command, Accumulator accumulator) {
        this.accumulator = accumulator;
        command.accept(this);
    }

    /**
     * decorator methods
     * @param message
     * @return
     */
    @Override
    public String decorInt(int message) {
        return PRIMITIVE + accumulator.getIntBuffer();
    }
    @Override
    public String decorString(String message) {
        return STRING + accumulator.getFullStr();
    }
    @Override
    public String decorByte(byte message) {
        return PRIMITIVE + accumulator.getByteBuffer();
    }
    @Override
    public String decorChar(char message) {
        return CHAR + message;
    }
    @Override
    public String decorBoolean(boolean message) {
        return PRIMITIVE + message;
    }
    @Override
    public String decorObject(Object message) {
        return REFERENCE + message;
    }
    @Override
    public String decorArray(int[] message) {
        StringBuilder stringBuilder = new StringBuilder(PRIMITIVE_ARRAY);
        stringBuilder = arrToString(message, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    @Override
    public String decorMatrix(int[][] message) {
        StringBuilder stringBuilder = new StringBuilder(PRIMITIVE_MATRIX);
        for (int[] item : message) {
            stringBuilder.append("{");
            stringBuilder = arrToString(item, stringBuilder);
            stringBuilder.append("}\r\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    private StringBuilder arrToString(int[] arr, StringBuilder stringBuilder) {
        for (int item : arr) {
            stringBuilder.append(item + ", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder;
    }
}
