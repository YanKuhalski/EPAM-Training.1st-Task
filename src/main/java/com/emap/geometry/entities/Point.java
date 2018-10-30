package com.emap.geometry.entities;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point " + "x = " + x + ", y = " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        if (Double.compare(point.getX(), getX()) != 0) {
            return false;
        }
        if (Double.compare(point.getY(), getY()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getX());
        int result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


