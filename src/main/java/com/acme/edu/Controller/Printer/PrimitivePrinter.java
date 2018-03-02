package com.acme.edu.Controller.Printer;

public class PrimitivePrinter extends Printer {
    boolean flag = true;
    @Override
    public void print(Object messege) {
        if (flag){
            System.out.println("primitive: ");
            flag = false;
        }
        System.out.println(messege);
    }
}
