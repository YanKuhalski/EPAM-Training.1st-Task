package com.emap.geometry.entities;

public class QuadrilateralParametrs {
    private double area;
    private double perimetr;

    public QuadrilateralParametrs(double area, double perimetr) {
        this.area = area;
        this.perimetr = perimetr;
    }

    @Override
    public String toString() {
        return "QuadrilateralParametrs  :" +
                "area = " + area + ", perimetr = " + perimetr;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != QuadrilateralParametrs.class) {
            return false;
        }

        QuadrilateralParametrs parametrs = (QuadrilateralParametrs) obj;

        if (Double.compare(parametrs.area, area) != 0) {
            return false;
        }
        return Double.compare(parametrs.perimetr, perimetr) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(area);
        int result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimetr);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
