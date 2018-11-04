package com.emap.geometry.entities;

import java.util.ArrayList;
import java.util.List;

public class Quadrilateral {
    private long id;
    protected List<Point> points;

    public Quadrilateral(List<Point> points, long id) {
        this.points = new ArrayList<>(points);
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quadrilateral : id = " + id + " \n");
        for (Point point : points) {
            sb.append("         " + point + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Quadrilateral that = (Quadrilateral) obj;
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
