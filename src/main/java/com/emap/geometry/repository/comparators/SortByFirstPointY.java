package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByFirstPointY implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral firstQuadrilateral, Quadrilateral secondQuadrilateral) {
        double firstY = firstQuadrilateral.getPoints().get(0).getY();
        double secondY = secondQuadrilateral.getPoints().get(0).getY();
        return Double.compare(secondY, firstY);
    }
}
