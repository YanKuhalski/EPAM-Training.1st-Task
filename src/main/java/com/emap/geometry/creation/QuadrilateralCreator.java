package com.emap.geometry.creation;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.validation.QuadrilateralDataValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuadrilateralCreator {
    private static final int NORMAL_AMOUNTH_OFPOINTS = 4;
    private static final Logger log = Logger.getLogger(QuadrilateralCreator.class);
    private final QuadrilateralDataValidator validator;

    public QuadrilateralCreator(QuadrilateralDataValidator validator) {
        this.validator = validator;
    }

    public Optional<Quadrilateral> create(List<Point> points) {
        if (validator.isValid(points)) {
            log.info("Quadrilateral data is valid");
            while (points.size() > NORMAL_AMOUNTH_OFPOINTS) {
                points.remove(points.size() - 1);
            }
            log.info("Quadrilateral was successfully created");
            long newId = IDGenerator.generateQuadrilateralID();
            List<Point> formatedPoints = makeFormatedPointList(points);
            Quadrilateral quadrilateral = new Quadrilateral(formatedPoints, newId);
            return Optional.of(quadrilateral);
        } else {
            log.error("Point list was invalid Quadrilateral creating was failed");
            return Optional.empty();
        }
    }

    private List<Point> makeFormatedPointList(List<Point> point) {
        List<Point> pointList = new ArrayList<>(point);
        Point higherPoint = findHigher(pointList);
        Point secondHightPoint = findHigher(pointList);
        Point thirdHightPoint = findHigher(pointList);
        Point lhessHightPoint = findHigher(pointList);

        Point firstPoint = getLeftPoint(higherPoint, secondHightPoint);
        Point secondPoint;
        if (firstPoint == higherPoint) {
            secondPoint = secondHightPoint;
        } else {
            secondPoint = higherPoint;
        }

        Point fourthPoint = getLeftPoint(thirdHightPoint, lhessHightPoint);
        Point thirdPoint;
        if (fourthPoint == thirdHightPoint) {
            thirdPoint = lhessHightPoint;
        } else {
            thirdPoint = thirdHightPoint;
        }

        List<Point> points = new ArrayList<Point>();
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(thirdPoint);
        points.add(fourthPoint);

        return points;
    }

    private Point findHigher(List<Point> points) {
        Point higher = points.get(0);
        for (Point point : points) {
            double pointY = point.getY();
            if (higher.getY() <= pointY) {
                higher = point;
            }
        }
        points.remove(higher);
        return higher;
    }

    private Point getLeftPoint(Point first, Point second) {
        Point leftPoint;
        double firstX = first.getX();
        double secondtX = second.getX();
        if (firstX > secondtX) {
            leftPoint = second;
        } else {
            leftPoint = first;
        }
        return leftPoint;
    }
}
