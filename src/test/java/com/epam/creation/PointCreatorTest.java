package com.epam.creation;

import com.emap.creation.PointCreator;
import com.emap.entities.Point;
import com.emap.exeptions.DataExeption;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class PointCreatorTest {
    private static final PointCreator creator = new PointCreator();

    @DataProvider
    public static Object[][] creatorDataProvider() {
        // @formatter:off
        return new Object[][]{
                {new double[]{-2.3, 2.3, 5.64, 322.55, 22.4, -12.2, 123.1, 12.1, -2.3}},
                {new double[]{2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3, 2.3}},
                {new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}},
                {new double[]{1.5, 1.5, 2.3, 2.3, 3, 5.64, 5.64, 322.55}}
        };
        // @formatter:on
    }

    @Test
    @UseDataProvider("creatorDataProvider")
    public void shouldReturnPointsWhenInputIsCorrect(double[] array) {
        //given
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < array.length / 2 * 2; i++) {
            pointList.add(new Point(array[i++], array[i]));
        }

        //when
        List<Point> points = creator.creatPoints(array);

        //then
        Assert.assertEquals(points, pointList);
    }
}
