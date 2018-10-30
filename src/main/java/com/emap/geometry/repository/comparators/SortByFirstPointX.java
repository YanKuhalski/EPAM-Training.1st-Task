package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByFirstPointX implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral o1, Quadrilateral o2) {
        double firstX = o1.getPoints().get(0).getX();
        double secondX = o2.getPoints().get(0).getX();
        return Double.compare(secondX, firstX);
    }
}
