package com.emap.geometry.creation;

import com.emap.geometry.entities.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointCreator {
    private  static  final Logger log = Logger.getLogger(PointCreator.class);

    public List<Point> creatPoints(double[] array) {
        int amounthOfPairs = array.length / 2;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < amounthOfPairs * 2; i++) {
            points.add(creatPoint(array[i++], array[i]));
        }
        log.info("Point list was successfully created");
        return points;
    }

    private Point creatPoint(double x, double y) {
        return new Point(x, y);
    }
}
