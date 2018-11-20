package com.epam.geometry.repository.comparators;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.comparators.SortByID;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SortByIDTest {
    private static final Point secondPoint = new Point(1, 1);
    private static final Point thirdPoint = new Point(1, 0);
    private static final Point fourthPoint = new Point(0, 0);

    @Test
    public void shouldSortSetByID() {
        //givenl
        Quadrilateral firstQuadrilateral = new Quadrilateral(Arrays.asList(new Point(1, 4), secondPoint, thirdPoint, fourthPoint)
                , 1);
        Quadrilateral secondQuadrilateral = new Quadrilateral(Arrays.asList(new Point(2, 2), secondPoint, thirdPoint, fourthPoint)
                , 2);
        Quadrilateral thirdQuadrilateral = new Quadrilateral(Arrays.asList(new Point(0, 1), secondPoint, thirdPoint, fourthPoint)
                , 3);

        List<Quadrilateral> list = Arrays.asList(firstQuadrilateral, secondQuadrilateral, thirdQuadrilateral);
        Set<Quadrilateral> sortdSet = new TreeSet<>(new SortByID());

        //when
        sortdSet.addAll(list);

        //then
        List<Quadrilateral> sortedList = new ArrayList<>(sortdSet);

        Assert.assertEquals(list.get(0), sortedList.get(0));
        Assert.assertEquals(list.get(1), sortedList.get(1));
        Assert.assertEquals(list.get(2), sortedList.get(2));
    }
}
