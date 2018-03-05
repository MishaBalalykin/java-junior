package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class StringHandler implements Handler {
    private String stringMessage;
    private String lastStr = "";
    private String fullStr = "";
    private int buffer;

    public StringHandler(String message) {
        stringMessage = message;
    }


    @Override
    public void perform() {
        buildStr(stringMessage);
    }

    private void buildStr(String stringMessage){
        if(stringMessage.equals(lastStr)){
            buffer++;
        } else {
            indexingStr();
            fullStr += stringMessage + "\n";
        }
        lastStr = stringMessage;
    }

    private void indexingStr(){
        if(buffer > 0){
            deleteLastSymStr();
            fullStr += " (x" + (buffer + 1) + ")\n";
            buffer = 0;
        }
    }

    private void deleteLastSymStr() {
        if(!fullStr.equals("")){
            StringBuilder stringBuilder = new StringBuilder(fullStr);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            fullStr = stringBuilder.toString();
        }
    }

    @Override
    public void flush() {
        indexingStr();
        deleteLastSymStr();
        printer.print(design.getType()+fullStr);
        fullStr = "";
        lastStr = "";
    }


}
