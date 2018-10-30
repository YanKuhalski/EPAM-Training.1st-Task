package com.epam.geometry.validation;

import com.emap.geometry.validation.StringValidator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class StringValidatorTest {
    private static final StringValidator validator = new StringValidator();

    @DataProvider
    public static Object[][] validatorDataProvider() {
        return new Object[][]{
                {"-2.3 2.3 5.64 322.55 22.4 -12.2 123.1 12.1 -2.3 ", true},
                {"2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 ", true},
                {"2.3 2.3 werwe2.3 2.3 2.3 2. wer2.3 2.wer3 2.3 ", false},
                {"2.3 2.3 2.ewr3 2.3 2.ewrw3 2.3 2.3 2.3 2.3 2.3 2.3 ", false},
                {"1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 ", true},
                {"1.5 1.5 2.3 2.3 3.6 5.64 5.64 322.55 ", true}
        };
    }

    @Test
    @UseDataProvider("validatorDataProvider")
    public void shouldReturnDoubleArraysWhenInputIsCorrect(String string, boolean expected) {
        //given

        //when
        boolean result = validator.isValid(string);

        //then
        Assert.assertEquals(expected, result);
    }
}
