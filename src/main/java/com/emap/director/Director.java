package com.emap.director;

import com.emap.calculator.Calculator;
import com.emap.creation.PointCreator;
import com.emap.creation.QuadrilateralCreator;
import com.emap.entities.Point;
import com.emap.entities.Quadrilateral;
import com.emap.enums.ShapeType;
import com.emap.parse.StringParser;
import com.emap.reader.impl.DataReader;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader dataReader;
    private final StringParser stringParser;
    private final PointCreator pointCreator;
    private final QuadrilateralCreator quadrilateralCreator;
    private final Calculator calculator;

    public Director(DataReader dataReader, StringParser stringParser, PointCreator pointCreator, QuadrilateralCreator quadrilateralCreator, Calculator calculator) {
        this.dataReader = dataReader;
        this.stringParser = stringParser;
        this.pointCreator = pointCreator;
        this.quadrilateralCreator = quadrilateralCreator;
        this.calculator = calculator;
    }

    public List<Quadrilateral> createQuadrilateralList(String path) {
        List<String> data = dataReader.readStrings(path);
        List<List<Point>> quadrilateralData = new ArrayList<>();

        for (String string : data) {
            double[] parsedData = stringParser.parse(string);
            List<Point> pointList = pointCreator.creatPoints(parsedData);
            quadrilateralData.add(pointList);
        }

        List<Quadrilateral> quadrilaterals = new ArrayList<>();

        for (List<Point> points : quadrilateralData) {
            Quadrilateral quadrilateral = quadrilateralCreator.create(points);
            quadrilaterals.add(quadrilateral);
        }

        return quadrilaterals;
    }

    public double[] calculateAreas(List<Quadrilateral> quadrilaterals) {
        double[] areas = new double[quadrilaterals.size()];
        for (int i = 0; i < areas.length; i++) {
            areas[i] = calculator.calculateArea(quadrilaterals.get(i));
        }
        return areas;
    }

    public double[] calculatePerimetrs(List<Quadrilateral> quadrilaterals) {
        double[] perimetrs = new double[quadrilaterals.size()];
        for (int i = 0; i < perimetrs.length; i++) {
            perimetrs[i] = calculator.calculatePerimetr(quadrilaterals.get(i));
        }
        return perimetrs;
    }

    public ShapeType[] defineShapeType(List<Quadrilateral> quadrilaterals) {
        ShapeType[] perimetrs = new ShapeType[quadrilaterals.size()];
        for (int i = 0; i < perimetrs.length; i++) {
            perimetrs[i] = calculator.defineTypeOfQuadrilateral(quadrilaterals.get(i));
        }
        return perimetrs;
    }
}
