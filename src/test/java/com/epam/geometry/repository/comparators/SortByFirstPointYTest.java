package com.epam.geometry.repository.comparators;

import com.emap.geometry.creation.IDGenerator;
import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.comparators.SortByFirstPointY;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortByFirstPointYTest {
    @Test
    public void shouldSortSetByFirstPointY() {
        //given
        Point secondPoint = new Point(1, 1);
        Point thirdPoint = new Point(1, 0);
        Point fourthPoint = new Point(0, 0);

        Quadrilateral firstQuadrilateral = new Quadrilateral(Arrays.asList(new Point(0, 4), secondPoint, thirdPoint, fourthPoint)
                , IDGenerator.generateQuadrilateralID());
        Quadrilateral secondQuadrilateral = new Quadrilateral(Arrays.asList(new Point(0, 2), secondPoint, thirdPoint, fourthPoint)
                , IDGenerator.generateQuadrilateralID());
        Quadrilateral thirdQuadrilateral = new Quadrilateral(Arrays.asList(new Point(0, 1), secondPoint, thirdPoint, fourthPoint)
                , IDGenerator.generateQuadrilateralID());

        List<Quadrilateral> list = Arrays.asList(firstQuadrilateral, secondQuadrilateral, thirdQuadrilateral);
        Set<Quadrilateral> sortdSet = new TreeSet<>(new SortByFirstPointY());

        //when
        sortdSet.addAll(list);

        //then
        int counter = 0;
        for (Quadrilateral quadrilateral : sortdSet) {
            Assert.assertEquals(list.get(counter++), quadrilateral);

        }
    }
}
