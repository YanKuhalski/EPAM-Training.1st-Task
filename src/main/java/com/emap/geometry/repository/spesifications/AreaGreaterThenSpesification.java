package com.emap.geometry.repository.spesifications;

import com.emap.geometry.calculator.Calculator;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.Spesification;

public class AreaGreaterThenSpesification implements Spesification<Quadrilateral> {
    private double area;

    private final Calculator calculator = new Calculator();

    public AreaGreaterThenSpesification(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Quadrilateral o) {
        double currentArea = calculator.calculateArea(o);
        return Double.compare(currentArea, area) > 0;
    }
}
