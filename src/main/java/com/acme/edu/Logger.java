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
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {
    static int countInt;
    static int countStr;
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion


    public static void log(int message) {
        //region output
        //print(message,"primitive");
        //print(message);
        if(message == Integer.MAX_VALUE){
            print(countInt);
            print(Integer.MAX_VALUE);
            countInt = 0;
        } else{
            countInt += message;
        }
        if (message == 0) {
            print(message);
        }
        //endregion
    }

    public static void log(byte message) {
        //region output
        //print(message,"primitive");
        print(message);
        //endregion
    }

    public static void log(char message) {
        //region output
        //print(message,"char");
        print(message);
        //endregion
    }

    public static void log(String message) {
        //region output
        //print(message,"string");
        if (countInt != 0)
            print(countInt);
        print(message);
        countInt = 0;
        //endregion
    }

    public static void log(boolean message) {
        //region output
        //print(message,"primitive");
        print(message);
        //endregion
    }

    public static void log(Object message) {
        //region output
        //print(message,"reference");
        print(message);
        //endregion
    }

    private static void print(Object message, String type) {
        System.out.println(type + ": " + message);
    }

    private static void print(Object message) {
        System.out.println(message);
    }

}

