package com.epam.reader;

import com.emap.reader.impl.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {
   private static final DataReader reader = new DataReader();

    @Test
    public void shouldReturnStringsWhenPathIsCorrect(){
        //given
        String path = "./src/main/resources/first.txt";
        List<String> strings = new ArrayList<>();
        strings.add("6,7 8,5 2,1 2,1 ");
        strings.add("3,8 7,3 4,1 1,4 ");
        strings.add("6,10 9,5 8,1 2,4 ");
        strings.add("0,8 8,8 8,0 0,0 ");
        strings.add("1,2 2,2 4,4 1,6 ");

        //when
        List<String> stringList=  reader.readStrings(path);

        //then
        Assert.assertEquals(strings,stringList);
    }
}
