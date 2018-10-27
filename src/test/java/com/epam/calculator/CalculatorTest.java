package com.epam.calculator;

import com.emap.calculator.Calculator;
import com.emap.creation.IDGenerator;
import com.emap.entities.Point;
import com.emap.entities.Quadrilateral;
import com.emap.enums.ShapeType;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private static final double DELTA = 0.01;

    @DataProvider
    public static Object[][] doubleProvider() {
        return new Object[][]{
                {2.123412, 2, 2.12},
                {2.4321, 3, 2.432},
                {345.2343332, 4, 345.2343},
        };
    }

    @Test
    @UseDataProvider(("doubleProvider"))
    public void shouldReturnParsedDouble(double value, int numberOfzero, double expected) {
        double result = calculator.roundToDischarge(value, numberOfzero);
        Assert.assertEquals(Double.compare(result, expected), 0);
    }

    @DataProvider
    public static Object[][] areaColculationDataProvider() {
        return new Object[][]{
                {new Point(6, 7), new Point(8, 5), new Point(2, 1), new Point(2, 1), 10},
                {new Point(3, 8), new Point(7, 3), new Point(4, 1), new Point(1, 4), 20.5},
                {new Point(6, 10), new Point(9, 5), new Point(8, 1), new Point(2, 4), 32.5},
                {new Point(0, 8), new Point(8, 8), new Point(8, 0), new Point(0, 0), 64},
                {new Point(1, 2), new Point(2, 2), new Point(4, 4), new Point(1, 6), 7}
        };
    }

    @Test
    @UseDataProvider("areaColculationDataProvider")
    public void shouldCalculateAndReturnArea(Point first, Point second, Point third, Point fourth, double expected) {
        //given
        List<Point> points = new ArrayList<>();
        points.add(first);
        points.add(second);
        points.add(third);
        points.add(fourth);
        Quadrilateral quadrilateral = new Quadrilateral(points, IDGenerator.generateQuadrilateralID());

        //when
        double result = calculator.calculateArea(quadrilateral);

        //then
        Assert.assertEquals(expected, result, DELTA);
    }

    @DataProvider
    public static Object[][] perimetrColculationDataProvider() {
        return new Object[][]{
                {new Point(6, 7), new Point(8, 5), new Point(2, 1), new Point(2, 1), 17.25},
                {new Point(3, 8), new Point(7, 3), new Point(4, 1), new Point(1, 4), 18.72},
                {new Point(6, 10), new Point(9, 5), new Point(8, 1), new Point(2, 4), 23.87},
                {new Point(0, 8), new Point(8, 8), new Point(8, 0), new Point(0, 0), 32.0},
                {new Point(1, 2), new Point(2, 2), new Point(4, 4), new Point(1, 6), 11.43}
        };
    }

    @Test
    @UseDataProvider("perimetrColculationDataProvider")
    public void shouldCalculateAndReturnPerimetr(Point first, Point second, Point third, Point fourth, double expected) {
        //given
        List<Point> points = new ArrayList<>();
        points.add(first);
        points.add(second);
        points.add(third);
        points.add(fourth);
        Quadrilateral quadrilateral = new Quadrilateral(points, IDGenerator.generateQuadrilateralID());

        //when
        double result = calculator.calculatePerimetr(quadrilateral);

        //then
        Assert.assertEquals(expected, result, DELTA);
    }

    @DataProvider
    public static Object[][] typeDefineDataProvider() {
        return new Object[][]{
                {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1), ShapeType.SQUARE},
                {new Point(2, 4), new Point(6, 4), new Point(8, 0), new Point(0, 0), ShapeType.TRAPEZIUM},
                {new Point(6, 10), new Point(9, 5), new Point(8, 1), new Point(2, 4), ShapeType.CONVEX_QUADRILATERAL},
                {new Point(4, 8), new Point(8, 0), new Point(4, 0), new Point(0, 0), ShapeType.TRIANGLE},
                {new Point(1, 2), new Point(5, 2), new Point(4, 4), new Point(1, 6), ShapeType.CONVEX_QUADRILATERAL}
        };
    }

    @Test
    @UseDataProvider("typeDefineDataProvider")
    public void shouldDefineAndReturnShapeType(Point first, Point second, Point third, Point fourth, ShapeType expected) {
        //given
        List<Point> points = new ArrayList<>();
        points.add(first);
        points.add(second);
        points.add(third);
        points.add(fourth);
        Quadrilateral quadrilateral = new Quadrilateral(points, IDGenerator.generateQuadrilateralID());

        //when
        ShapeType result = calculator.defineTypeOfQuadrilateral(quadrilateral);

        //then
        Assert.assertEquals(result, expected);
    }
}
