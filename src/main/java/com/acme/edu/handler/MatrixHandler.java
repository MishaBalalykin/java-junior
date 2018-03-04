package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class MatrixHandler extends Handler {
    public MatrixHandler(Printer printer, Design design) {
        super(printer, design);
    }

    @Override
    public void perform(Object message) {
        StringBuilder stringBuilder = new StringBuilder(design.getType()+"\r\n");
        for (int[] item : (int[][])message){
            stringBuilder.append("{");
            stringBuilder = arrToString(item,stringBuilder);
            stringBuilder.append("}\r\n");
        }
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
}
