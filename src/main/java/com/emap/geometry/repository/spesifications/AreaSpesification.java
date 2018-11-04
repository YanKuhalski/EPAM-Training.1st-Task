package com.emap.geometry.repository.spesifications;

import com.emap.geometry.calculator.Calculator;
import com.emap.geometry.entities.Quadrilateral;

public class AreaSpesification implements Spesification<Quadrilateral> {
    private double area;
    private final Calculator calculator = new Calculator();

    public AreaSpesification(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Quadrilateral o) {
        double currentArea = calculator.calculateArea(o);
        currentArea = calculator.roundToDischarge(currentArea, 2);
        area = calculator.roundToDischarge(area, 2);
        return Double.compare(currentArea, area) == 0;
    }
}
