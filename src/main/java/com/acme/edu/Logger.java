package com.acme.edu;

import com.acme.edu.buisnesLogic.*;
import com.acme.edu.command.*;

/**
 * Logs messages.
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {
    private static Accumulator accumulator = new Summator();

    /**
     * @param message
     * @author Misha
     * log for Integer
     */
    public static void log(int message) {
        //region output
        new Controller(new IntegerCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param message
     * @author Misha
     * log for Byte
     */
    public static void log(byte message) {
        //region output
        new Controller(new ByteCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param message
     * @author Misha
     * log for Char
     */
    public static void log(char message) {
        //region output
        new Controller(new CharCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param message
     * @author Misha
     * log for String
     */
    public static void log(String message) {
        //region output
        new Controller(new StringCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param message
     * @author Misha
     * log for Boolean
     */
    public static void log(boolean message) {
        //region output
        new Controller(new BooleanCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param message
     * @author Misha
     * log for Object
     */
    public static void log(Object message) {
        //region output
        new Controller(new ObjectCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param arr
     * @author Misha
     * log for simple Array
     */
    public static void log(int[] arr) {
        //region output
        new Controller(new ArrayCommand(arr)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @param arr
     * @author Misha
     * log for simple Matrix
     */
    public static void log(int[][] arr) {
        //region output
        new Controller(new MatrixCommand(arr)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    /**
     * @author Misha
     * method for flush buffers from tests
     */
    public static void flush() {
        //region set(0)
        accumulator.indexingStr();
        accumulator.setIntBuffer(0);
        accumulator.setByteBuffer((byte) 0);
        //endregion
    }
}



