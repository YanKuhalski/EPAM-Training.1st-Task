package com.emap.geometry.repository.comparators;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;

import java.util.Comparator;
import java.util.List;

public class SortByFirstPointY implements Comparator<Quadrilateral> {
    @Override
    public int compare(Quadrilateral firstQuadrilateral, Quadrilateral secondQuadrilateral) {
        List<Point> firstPointList = firstQuadrilateral.getPoints();
        List<Point> secondPointList = secondQuadrilateral.getPoints();
        Point firstPoint = firstPointList.get(0);
        Point scondPoint = secondPointList.get(0);
        double firstY = firstPoint.getY();
        double secondY = scondPoint.getY();
        return Double.compare(secondY, firstY);
    }
}
