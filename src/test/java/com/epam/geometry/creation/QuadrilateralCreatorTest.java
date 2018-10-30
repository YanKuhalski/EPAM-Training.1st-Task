package com.epam.geometry.creation;

import com.emap.geometry.creation.IDGenerator;
import com.emap.geometry.creation.QuadrilateralCreator;
import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.validation.QuadrilateralDataValidator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(DataProviderRunner.class)
public class QuadrilateralCreatorTest {
    private static final QuadrilateralDataValidator validator = Mockito.mock(QuadrilateralDataValidator.class);
    private static final QuadrilateralCreator creator = new QuadrilateralCreator(validator);

    @DataProvider
    public static Object[][] creatorDataProvider() {
        return new Object[][]{
                {new Point(6, 7), new Point(8, 5), new Point(2, 1), new Point(2, 1)},
                {new Point(1, 4), new Point(3, 8), new Point(7, 3), new Point(4, 1)},
                {new Point(6, 10), new Point(9, 5), new Point(8, 1), new Point(2, 4)},
                {new Point(0, 8), new Point(8, 8), new Point(8, 0), new Point(0, 0)},
                {new Point(1, 6), new Point(4, 4), new Point(2, 2), new Point(1, 2), new Point(1, 2), new Point(1, 2)}
        };
    }

    @Test
    @UseDataProvider("creatorDataProvider")
    public void shouldReturnQuadrilateralWhenInputIsCorrect(Point... pointArray) {
        //given
        List<Point> points = new ArrayList<>();
        points.add(pointArray[0]);
        points.add(pointArray[1]);
        points.add(pointArray[2]);
        points.add(pointArray[3]);

        Quadrilateral expectedQud = new Quadrilateral(points, IDGenerator.generateQuadrilateralID());

        Mockito.when(validator.isValid(Mockito.any(ArrayList.class)))
                .thenReturn(true);
        Optional<Quadrilateral> expected = Optional.of(expectedQud);

        //when
        Optional<Quadrilateral> result = creator.create(points);

        //then
        Assert.assertEquals(expected, result);
    }
}
