package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class ByteHandler implements Handler {
    private byte buffer;

    public ByteHandler(Printer printer, Design design) {

    }

    private void summer(byte message) {
        if(!checkOwerflow(message)){
            buffer += message;
        }
    }

    private boolean checkOwerflow(byte message) {
        byte delta = (byte) (Byte.MAX_VALUE - buffer);
        if (message > delta) {
            printer.print(design.getType()+Byte.MAX_VALUE);
            buffer = (byte) (message - delta);
            return  true;
        } else printer.print(design.getType()+message);
        return false;
    }

    @Override
    public void perform(Object message) {
        summer((Byte) message);
    }

    @Override
    public void flush() {
        printer.print(design.getType()+buffer);
        buffer = 0;
    }
}
