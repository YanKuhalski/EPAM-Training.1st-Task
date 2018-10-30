package com.epam.geometry.parsing.impl;

import com.emap.geometry.parsing.StringParser;
import com.emap.geometry.parsing.impl.StringParserImpl;
import com.emap.geometry.validation.StringValidator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(DataProviderRunner.class)
public class StringParserImplTest {
    private static final StringValidator validator = Mockito.mock(StringValidator.class);
    private static final StringParser parser = new StringParserImpl(validator);

    @DataProvider
    public static Object[][] parserDataProvider() {
        return new Object[][]{
                {"-2.3 2.3 5.64 322.55 22.4 -12.2 123.1 12.1 -2.3 ", new double[]{-2.3, 2.3, 5.64, 322.55, 22.4, -12.2, 123.1, 12.1, -2.3}},
                {"2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 2.3 ", new double[]{2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3}},
                {"1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 1.5 ", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}},
                {"1.5 1.5 2.3 2.3 3 5.64 5.64 322.55 ", new double[]{1.5, 1.5, 2.3, 2.3, 3, 5.64, 5.64, 322.55}}
        };
    }

    @Test
    @UseDataProvider("parserDataProvider")
    public void shouldReturnDoubleArraysWhenInputIsCorrect(String string, double[] expected) {
        //given
        Mockito.when(validator.isValid(Mockito.any(String.class)))
                .thenReturn(true);

        //when
        double[] result = parser.parse(string);

        //then
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i] == result[i], true);
        }
    }
}
