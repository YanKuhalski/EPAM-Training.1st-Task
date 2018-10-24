package com.epam.validation;

import com.emap.entities.Point;
import com.emap.validation.QuadrilateralDataValidator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class QuadrilateralDataValidatorTest {
    private static final QuadrilateralDataValidator quadrilateral = new QuadrilateralDataValidator();

    @DataProvider
    public static Object[][] validatorDataProvider() {
        return new Object[][]{
                {new Point(6, 7), new Point(8, 5), new Point(2, 1), new Point(2, 1), false},
                {new Point(3, 8), new Point(7, 3), new Point(4, 1), new Point(1, 4), true},
                {new Point(6, 10), new Point(9, 5), new Point(8, 1), new Point(2, 4), true},
                {new Point(0, 8), new Point(8, 0), new Point(8, 0), new Point(0, 0), false},
                {new Point(1, 2), new Point(2, 2), new Point(4, 4), new Point(1, 6), true}
        };
    }

    @Test
    @UseDataProvider("validatorDataProvider")
    public void shouldReturnBooleanaWhenInputIsCorrect(Point first, Point second, Point third, Point fourth, boolean expected) {
        //given
        List<Point> points = new ArrayList<>();
        points.add(first);
        points.add(second);
        points.add(third);
        points.add(fourth);

        //when
        boolean result = quadrilateral.isValid(points);
        //then
        Assert.assertEquals(result, expected);
    }
}
