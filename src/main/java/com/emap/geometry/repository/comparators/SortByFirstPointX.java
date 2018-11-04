package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByFirstPointX implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral firstQuadrilateral, Quadrilateral secondQuadrilateral) {
        double firstX = firstQuadrilateral.getPoints().get(0).getX();
        double secondX = secondQuadrilateral.getPoints().get(0).getX();
        return Double.compare(secondX, firstX);
    }
}
