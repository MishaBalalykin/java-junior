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

    public static void log(int message) {
        //region output
        new Controller(new IntegerCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    public static void log(byte message) {
        //region output
        new Controller(new ByteCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(), accumulator);
        //endregion
    }

    public static void log(char message) {
        //region output
        new Controller(new CharCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void log(String message) {
        //region output
        new Controller(new StringCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void log(boolean message) {
        //region output
        new Controller(new BooleanCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void log(Object message) {
        //region output
        new Controller(new ObjectCommand(message)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void log(int[] arr) {
        //region output
        new Controller(new ArrayCommand(arr)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void log(int[][] arr) {
        //region output
        new Controller(new MatrixCommand(arr)).execute(new PrefixDecorator(), new ConsoleSaver(),accumulator);
        //endregion
    }

    public static void flush(){
        //region set(0)
        accumulator.setIntBuffer(0);
        accumulator.setStringBuffer(0);
        accumulator.setByteBuffer((byte) 0);
        //endregion
    }
}



