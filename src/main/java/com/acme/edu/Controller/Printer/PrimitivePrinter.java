package com.acme.edu.Controller.Printer;

public class PrimitivePrinter extends Printer {
    boolean flag = true;
    public PrimitivePrinter(Object messege, String type) {
        super(messege, type);
        super.print();
    }

    @Override
    public void print() {
        if (flag) {
            System.out.println(type + ": ");
            flag = false;
        }
        System.out.println(messege);
    }




}
