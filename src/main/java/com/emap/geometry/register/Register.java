package com.emap.geometry.register;

import com.emap.geometry.calculator.Calculator;
import com.emap.geometry.entities.QuadrilateralParametrs;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Register implements Observer<ObservableQuadrilateral> {
    private static final Logger log = Logger.getLogger(Register.class);
    private static Register instance;
    private Map<Long, QuadrilateralParametrs> parametrs;
    private final static Calculator calculator = new Calculator();

    private Register() {
        parametrs = new HashMap<>();
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

    @Override
    public void update(ObservableQuadrilateral quadrilateral) {
        double area = calculator.calculateArea(quadrilateral);
        double perimetr = calculator.calculatePerimetr(quadrilateral);
        area = calculator.roundToDischarge(area, 2);
        perimetr = calculator.roundToDischarge(perimetr, 2);
        QuadrilateralParametrs parametr = new QuadrilateralParametrs(area, perimetr);
        long id = quadrilateral.getId();
        if (parametrs.get(id) == null) {
            parametrs.put(id, parametr);
            log.info("Register was supplemented by element with id " + id);
        } else {
            parametrs.replace(id, parametr);
            log.info("Register was update, element with id " + id + " was changed");
        }
    }
}
