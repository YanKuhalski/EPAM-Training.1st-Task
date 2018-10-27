package com.epam.repository.spesifications;

import com.emap.creation.IDGenerator;
import com.emap.entities.Point;
import com.emap.entities.Quadrilateral;
import com.emap.repository.Spesification;
import com.emap.repository.spesifications.AreaGreaterThenSpesification;
import com.emap.repository.spesifications.AreaSpesification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AreaSpesificationTest {
    @Test
    public void shouldReturnTrueWhenAreaIsEquals() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(
                Arrays.asList(new Point(6, 7),
                        new Point(8, 5),
                        new Point(2, 1),
                        new Point(2, 1)),
                IDGenerator.generateQuadrilateralID());
        Spesification<Quadrilateral> spesification = new AreaSpesification(10);
        //when
        boolean result = spesification.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }
}
