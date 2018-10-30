package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByFirstPointY implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral o1, Quadrilateral o2) {
        double firstY = o1.getPoints().get(0).getY();
        double secondY = o2.getPoints().get(0).getY();
        return Double.compare(secondY, firstY);
    }
}
