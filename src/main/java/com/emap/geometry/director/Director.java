package com.emap.geometry.director;

import com.emap.geometry.calculator.Calculator;
import com.emap.geometry.creation.PointCreator;
import com.emap.geometry.creation.QuadrilateralCreator;
import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.parsing.StringParser;
import com.emap.geometry.reading.DataReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

            Optional<Quadrilateral> quadrilateral = quadrilateralCreator.create(points);
            if (quadrilateral.isPresent()) {
                quadrilaterals.add(quadrilateral.get());
            }
        }
        return quadrilaterals;
    }
}
