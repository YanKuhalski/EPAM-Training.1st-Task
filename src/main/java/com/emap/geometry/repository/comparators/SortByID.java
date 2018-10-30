package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;

public class SortByID implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral o1, Quadrilateral o2) {
        return (int) (o1.getId() - o2.getId());
    }
}
