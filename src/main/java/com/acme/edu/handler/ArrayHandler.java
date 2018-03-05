package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class ArrayHandler extends Handler {
    public ArrayHandler(Printer printer, Design design) {
        super(printer, design);
    }

    @Override
    public void perform(Object message) {
        StringBuilder stringBuilder = new StringBuilder(design.getType());
        stringBuilder = arrToString((int[])message, stringBuilder);
        stringBuilder.append("}");
        printer.print(stringBuilder.toString());
    }

    @Override
    public void flush() {

    }

    private StringBuilder arrToString(int[] arr, StringBuilder stringBuilder){
        for (int item : arr){
            stringBuilder.append(item+", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return  stringBuilder;
    }

    /*private void print(Object message) {
        System.out.println(message);
    }*/
}
