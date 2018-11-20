package com.epam.geometry.reading;

import com.emap.geometry.reading.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {
    private static String PATH = "./src/main/resources/first.txt";
    private static List<String> EXPECTED_STRINGS = Arrays.asList("6,7 8,5 2,1 2,1 ",
            "3,8 7,3 4,1 1,4 ",
            "6,10 9,5 8,1 2,4 ",
            "0,8 8,8 8,0 0,0 ",
            "1,2 2,2 4,4 1,6 ");

    @Test
    public void shouldReturnStringsWhenPathIsCorrect() {
        //given

        DataReader reader = new DataReader();

        //when
        List<String> stringList = reader.readStrings(PATH);

        //then
        Assert.assertEquals(EXPECTED_STRINGS, stringList);
    }
}
