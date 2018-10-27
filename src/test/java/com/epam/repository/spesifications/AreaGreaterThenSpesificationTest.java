package com.epam.repository.spesifications;

import com.emap.creation.IDGenerator;
import com.emap.entities.Point;
import com.emap.entities.Quadrilateral;
import com.emap.repository.Spesification;
import com.emap.repository.spesifications.AreaGreaterThenSpesification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AreaGreaterThenSpesificationTest {
    @Test
    public void shouldReturnTrueWhenAreaIsMoreThen() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(
                Arrays.asList(new Point(6, 7),
                        new Point(8, 5),
                        new Point(2, 1),
                        new Point(2, 1)),
                IDGenerator.generateQuadrilateralID());
        Spesification<Quadrilateral> spesification = new AreaGreaterThenSpesification(4.2);
        //when
        boolean result = spesification.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }
}
