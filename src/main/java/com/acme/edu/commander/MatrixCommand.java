package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class MatrixCommand implements Command {
    private int[][] matrixMessage;
    private Printer printer;

    public MatrixCommand(int[][] message) {
        matrixMessage = message;
    }

    @Override
    public Command handle(Command command) {
        StringBuilder stringBuilder = new StringBuilder("primitives matrix: {"+"\r\n");
        for (int[] item : matrixMessage){
            stringBuilder.append("{");
            stringBuilder = arrToString(item,stringBuilder);
            stringBuilder.append("}\r\n");
        }
        stringBuilder.append("}");
        //printer.print(stringBuilder.toString());
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {

    }

    @Override
    public void flush() {

    }

    @Override
    public boolean isFlush() {
        return false;
    }

    private StringBuilder arrToString(int[] arr, StringBuilder stringBuilder){
        for (int item : arr){
            stringBuilder.append(item+", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return  stringBuilder;
    }
}
