package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */


import static com.acme.edu.Logger.*;
import static java.lang.Math.sin;

/**
 * Logs messages.
 * @author EK
 * @param
 * @see
 */
public class Logger {
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion


    public static void log(int message) {
        //region output
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(byte message) {
        //region output
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(char message) {
        //region output
        System.out.println("char: " + message);
        //endregion
    }

    public static void log(String message) {
        //region output
        System.out.println("string: " + message);
        //endregion
    }

    public static void log(boolean message) {
        //region output
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(Object message) {
        //region output
        System.out.println("reference: " + message);
        //endregion
    }

}

