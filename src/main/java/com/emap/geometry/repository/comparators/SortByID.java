package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByID implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral firstQuadrilateral, Quadrilateral secondQuadrilateral) {
        return (int) (firstQuadrilateral.getId() - secondQuadrilateral.getId());
    }
}
