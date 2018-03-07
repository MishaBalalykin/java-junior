package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class IntegerCommand implements Command {
    private int buffer;
    private int intMessage;
    private String forPrint;

    public IntegerCommand(int message) {
        intMessage = message;
    }


    private void accumulator(int intMessage) {
        if(!checkOwerflow(intMessage)){
            buffer += intMessage;

        }
    }

    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - buffer;
        if (intMessage > delta) {
            buffer = Integer.MAX_VALUE;
            flush();
            buffer = intMessage - delta;
            return  true;
        }
        return false;
    }

    @Override
    public Command handle(Command command) {
        if(command instanceof IntegerCommand){
            intMessage = ((IntegerCommand)command).getIntMessage();
            //System.out.println("check int: "+intMessage);
        }
        accumulator(intMessage);
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatInteger(this);
    }

    @Override
    public void flush() {
        buffer = 0;
    }

    public int getIntMessage(){
        return intMessage;
    }

    public int getBuffer(){
        return buffer;
    }

    public String toString(){
        return forPrint;
    }

}
