package com.emap.geometry.validation;

import com.emap.geometry.entities.Point;

import java.util.List;

public class QuadrilateralDataValidator {
    public boolean isValid(List<Point> points) {
        if (points.size()> 3) {
            Point first = points.get(0);
            Point second = points.get(1);
            Point third = points.get(2);
            Point fourth = points.get(3);
            return !(first.equals(second) | first.equals(third) | first.equals(fourth) | second.equals(third) | second.equals(fourth) | third.equals(fourth));
        } else {
            return false;
        }
    }
}
