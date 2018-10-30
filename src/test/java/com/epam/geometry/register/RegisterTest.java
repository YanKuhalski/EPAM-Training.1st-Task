package com.epam.geometry.register;

import com.emap.geometry.creation.IDGenerator;
import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.QuadrilateralParametrs;
import com.emap.geometry.register.ObservableQuadrilateral;
import com.emap.geometry.register.Register;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class RegisterTest {

    @Test
    public void shouldUpdateData() {
        ObservableQuadrilateral quadrilateral = new ObservableQuadrilateral(Arrays.asList(new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0),
                new Point(0, 0)),
                IDGenerator.generateQuadrilateralID());
        quadrilateral.addObserver();
        Map<Long, QuadrilateralParametrs> parametrs = Register.getInstance().getParametrs();
        quadrilateral.setPoins(Arrays.asList(new Point(0, 2),
                new Point(2, 2),
                new Point(2, 0),
                new Point(0, 0)));
        Map<Long, QuadrilateralParametrs> newPatametrs = Register.getInstance().getParametrs();

        Assert.assertEquals(parametrs.values(),newPatametrs.values());
    }
}
