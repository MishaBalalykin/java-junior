package com.acme.edu;

import com.acme.edu.disign.Design;
import com.acme.edu.handler.*;
import com.acme.edu.printer.ConsolePrinter;

/**
 * Logs messages.
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {
    private static IntegerHandler integerHandler= new IntegerHandler(new ConsolePrinter(), new Design("primitive: "));
    private static StringHandler stringHandler= new StringHandler(new ConsolePrinter(), new Design("string: "));
    private static ByteHandler byteHandler = new ByteHandler(new ConsolePrinter(), new Design("primitive: "));
    private static CharHandler charHandler = new CharHandler(new ConsolePrinter(), new Design("char: "));
    private static BooleanHandler booleanHandler = new BooleanHandler(new ConsolePrinter(), new Design("primitive: "));
    private static ObjectHandler objectHandler = new ObjectHandler(new ConsolePrinter(), new Design("reference: "));
    private static ArrayHandler arrayHandler = new ArrayHandler(new ConsolePrinter(), new Design("primitives array: {"));
    private static MatrixHandler matrixHandler = new MatrixHandler(new ConsolePrinter(), new Design("primitives matrix: {"));

    public static void log(int message) {
        //region output
        integerHandler.perform(message);
        flushStr();
        //endregion
    }

    public static void log(byte message) {
        //region output
        byteHandler.perform(message);
        //endregion
    }

    public static void log(char message) {
        //region output
        charHandler.perform(message);
        //endregion
    }

    public static void log(String message) {
        //region output
        flushInt();
        stringHandler.perform(message);
        //endregion
    }

    public static void log(boolean message) {
        //region output
        booleanHandler.perform(message);
        //endregion
    }

    public static void log(Object message) {
        //region output
        objectHandler.perform(message);
        //endregion
    }

    public static void log(int[] arr){
        arrayHandler.perform(arr);
    }

    public static void log(int[][] arr){
        matrixHandler.perform(arr);
    }

    public static void flushInt() {
        integerHandler.flush();
    }

    public static void flushStr(){
        stringHandler.flush();
    }

}