package com.acme.edu;

import com.acme.edu.commander.DefaultCommand;
import com.acme.edu.commander.Command;
import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.formatter.PostfixFormatter;
import com.acme.edu.formatter.PrefixFormatVisitor;
import com.acme.edu.printer.Printer;

public class LoggerController {
    private Printer printer;
    private Command currentCommand = new DefaultCommand();
    private FormatVisitor formatter = new PrefixFormatVisitor();

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void execute(Command command){
        if(command.getClass().equals(currentCommand.getClass())){
            currentCommand = currentCommand.handle(command);
        } else {
            flush();
            currentCommand = command;
            currentCommand = currentCommand.handle(command);
        }
    }


    public void flush(){
        save();
        currentCommand.flush();
    }

    public void save(){
        formatter.visit(currentCommand);
        printer.print(currentCommand);
    }

}
