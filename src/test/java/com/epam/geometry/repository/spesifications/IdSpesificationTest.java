package com.epam.geometry.repository.spesifications;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.spesifications.IdSpesification;
import com.emap.geometry.repository.spesifications.Spesification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class IdSpesificationTest {
    @Test
    public void shouldReturnTrueWhenIDIsEquals() {
        //given
        Quadrilateral quadrilateral = new Quadrilateral(
                Arrays.asList(new Point(6, 7),
                        new Point(8, 5),
                        new Point(2, 1),
                        new Point(2, 1)),
                4);
        Spesification<Quadrilateral> spesification = new IdSpesification(4);
        //when
        boolean result = spesification.specified(quadrilateral);

        //then
        Assert.assertTrue(result);
    }
}
