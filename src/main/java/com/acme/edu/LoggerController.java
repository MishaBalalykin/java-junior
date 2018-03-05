package com.acme.edu;

import com.acme.edu.handler.Handler;
import com.acme.edu.handler.MatrixHandler;
import com.acme.edu.handler.StringHandler;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.Printer;

public class LoggerController {

    //private Printer printer = new ConsolePrinter();
    private Handler currentHandlerr = new StringHandler("");

    public void execute(Handler handler){


        if(handler.getClass().equals(currentHandlerr.getClass())){

        }
        handler.perform();
    }


    public void flush(){
        handler.flush();
    }
}
