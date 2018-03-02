package com.acme.edu.Controller.Printer;

public class Printer {
    Object messege;
    String type;

    public Printer(Object messege, String type) {
        this.messege = messege;
        this.type = type;
    }

    public void print() {
        System.out.println(type + ": " + messege);
    }
}
