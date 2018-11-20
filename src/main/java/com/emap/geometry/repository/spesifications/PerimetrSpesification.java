package com.emap.geometry.repository.spesifications;

import com.emap.geometry.calculator.Calculator;
import com.emap.geometry.entities.Quadrilateral;

public class PerimetrSpesification implements Spesification<Quadrilateral> {
    private double perimetr;
    private final Calculator calculator = new Calculator();

    public PerimetrSpesification(double perimetr) {
        this.perimetr = perimetr;
    }

    @Override
    public boolean specified(Quadrilateral o) {
        double currentPerimetr = calculator.calculatePerimetr(o);
        currentPerimetr = calculator.roundToDischarge(currentPerimetr, 2);
        return Double.compare(currentPerimetr, perimetr) == 0;
    }
}
