package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class ArrayCommand implements Command {
    private int[] arrayMessage;
    private Printer printer;

    public ArrayCommand(int[] message) {
        arrayMessage = message;
    }

    @Override
    public Command handle(Command command) {
        StringBuilder stringBuilder = new StringBuilder("primitives array: {");
        //stringBuilder.append("{");
        stringBuilder = arrToString(arrayMessage, stringBuilder);
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
