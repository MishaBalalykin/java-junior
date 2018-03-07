package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.printer.Printer;

public class ByteCommand implements Command {
    private byte byteMessage;
    private byte buffer;

    private Printer printer;

    public ByteCommand(byte byteMessage) {
        this.byteMessage = byteMessage;
    }

    private void summer(byte byteMessage) {
        if(!checkOwerflow(byteMessage)){
            buffer += byteMessage;
        }
    }

    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - buffer);
        if (byteMessage > delta) {
            buffer = Byte.MAX_VALUE;
            flush();
            buffer = (byte) (byteMessage - delta);
            return  true;
        }
        return false;
    }

    public byte getByteMessage(){
        return byteMessage;
    }

    @Override
    public Command handle(Command command) {
        if(command instanceof ByteCommand){
            byteMessage = ((ByteCommand)command).getByteMessage();
        }
        summer(byteMessage);
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {

    }

    @Override
    public void flush() {
        //printer.print("primitive: "+buffer);
        buffer = 0;
    }

    @Override
    public boolean isFlush() {
        return false;
    }
}
