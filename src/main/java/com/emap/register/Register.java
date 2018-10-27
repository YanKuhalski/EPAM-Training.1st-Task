package com.emap.register;

import com.emap.calculator.Calculator;
import com.emap.entities.Quadrilateral;
import com.emap.entities.QuadrilateralParametrs;

import java.util.Map;

public class Register implements Observer<Quadrilateral> {
    private static Register instance;
    private Map<Long, QuadrilateralParametrs> parametrs;
    private final static Calculator calculator = new Calculator();

    private Register() {
    }

    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
        }
        return instance;
    }

    public Map<Long, QuadrilateralParametrs> getParametrs() {
        return parametrs;
    }

    public QuadrilateralParametrs getParametr(long id) {
        return parametrs.get(id);
    }

    @Override
    public void update(Quadrilateral quadrilateral) {
        double area = calculator.calculateArea(quadrilateral);
        double perimetr = calculator.calculatePerimetr(quadrilateral);
        area = calculator.roundToDischarge(area, 2);
        perimetr = calculator.roundToDischarge(perimetr, 2);
        QuadrilateralParametrs parametr = new QuadrilateralParametrs(area, perimetr);
        parametrs.replace(quadrilateral.getId(), parametr);
    }
}
