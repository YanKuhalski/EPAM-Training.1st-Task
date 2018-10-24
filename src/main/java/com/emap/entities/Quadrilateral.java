package com.emap.entities;

import java.util.ArrayList;
import java.util.List;

public class Quadrilateral {
    private final List<Point> points;

    public Quadrilateral(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quadrilateral: \n");
        for (Point point : points) {
            sb.append("         " + point + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Quadrilateral that = (Quadrilateral) o;

        for (int i = 0; i < 4; i++) {
            if (!(getPoints().get(i).equals(that.getPoints().get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getPoints() != null ? getPoints().hashCode() : 0;
    }
}
