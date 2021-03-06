package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion



    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion


        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");

        /*assertSysoutEquals(
            "str 1\r\n" +
            "3\r\n" +
            "str 2\r\n" +
            "0\r\n"
        );*/
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flushInt();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(""+Integer.MAX_VALUE);
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        /*assertSysoutEquals(
            "str 1\r\n" +
            "10\r\n" +
            Integer.MAX_VALUE + "\r\n" +
            "str 2\r\n" +
            "0\r\n"
        );*/
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(""+Byte.MAX_VALUE);
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        /*assertSysoutEquals(
            "str 1\r\n" +
            "10\r\n" +
            Byte.MAX_VALUE + "\r\n" +
            "str 2\r\n" +
            "0\r\n"
        );*/
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.flushStr();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
        /*assertSysoutEquals(
                "str 1\r\n" +
                        "str 2 (x2)\r\n" +
                        "0\r\n" +
                        "str 2\r\n" +
                        "str 3 (x3)\r\n"
        );*/
        //endregion
    }


}