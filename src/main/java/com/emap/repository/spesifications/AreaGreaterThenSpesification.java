package com.emap.repository.spesifications;

import com.emap.calculator.Calculator;
import com.emap.entities.Quadrilateral;
import com.emap.repository.Spesification;

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
