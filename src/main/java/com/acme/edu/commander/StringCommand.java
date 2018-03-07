package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class StringCommand implements Command {
    private String stringMessage;
    private Printer printer;
    private String lastStr = "";
    private String fullStr = "";
    private int buffer;

    public StringCommand(String message) {
        stringMessage = message;
    }


    @Override
    public Command handle(Command command) {
        if(command instanceof StringCommand){
            stringMessage = ((StringCommand)command).getStringMessage();
        }
        buildStr(stringMessage);
        return this;
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

    public String getStringMessage(){
        return stringMessage;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {

    }

    @Override
    public void flush() {
        indexingStr();
        deleteLastSymStr();
        fullStr = "";
        lastStr = "";
    }

    @Override
    public boolean isFlush() {
        return false;
    }

}
