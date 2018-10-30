package com.emap.geometry.parsing.impl;

import com.emap.geometry.exeptions.ParseExeption;
import com.emap.geometry.parsing.StringParser;
import com.emap.geometry.validation.StringValidator;
import org.apache.log4j.Logger;

public class StringParserImpl implements StringParser {
    private static final Logger log = Logger.getLogger(StringParserImpl.class);
    private final StringValidator validator;

    public StringParserImpl(StringValidator validator) {
        this.validator = validator;
    }

    @Override
    public double[] parse(String string) {
        try {
            log.info("String was successfully parsed");
            return patseToDoubleArray(string);
        } catch (ParseExeption parseExeption) {
            log.info(parseExeption);
            return null;
        }
    }

    private double[] patseToDoubleArray(String string) throws ParseExeption {
        double[] doubles;
        if (validator.isValid(string)) {
            log.info("String is valid");
            String[] numbers = string.split(" ");
            doubles = new double[numbers.length];
            int counter = 0;
            for (String str : numbers) {
                doubles[counter++] = Double.valueOf(str);
            }
            return doubles;
        } else {
            throw new ParseExeption("String is invalid");
        }
    }
}
