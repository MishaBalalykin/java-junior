package com.acme.edu.formatter;

import com.acme.edu.commander.*;

/**
 * @author MishaAndEugen
 * класс PrefixFormatVisitor отвечает за возможность изменения стиля вывода
 */
public class PrefixFormatVisitor implements FormatVisitor {

    @Override
    public String formatInteger(IntegerCommand integerCommand) {
        return "primitive: "+integerCommand.getBuffer();
    }

    @Override
    public String formatString(StringCommand stringCommand) {
        return null;
    }

    @Override
    public String formatByte(ByteCommand byteCommand) {
        return null;
    }

    @Override
    public String formatChar(CharCommand charCommand) {
        return null;
    }

    @Override
    public String formatBoolean(BooleanCommand booleanCommand) {
        return null;
    }

    @Override
    public String formatArray(ArrayCommand arrayCommand) {
        return null;
    }

    @Override
    public String formatMatrix(MatrixCommand matrixCommand) {
        return null;
    }

    @Override
    public String formatObject(ObjectCommand objectCommand) {
        return null;
    }
}
