package com.emap.geometry.calculator;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.enums.ShapeType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final Logger log = Logger.getLogger(Calculator.class);
    private static final double UNFOLDED_ANGLE = 180;

    public ShapeType defineTypeOfQuadrilateral(Quadrilateral quadrilateral) {
        List<Double> angles = getAngles(quadrilateral.getPoints());

        double firstAngle = angles.get(0);
        double secondAngle = angles.get(1);
        double thirdAngle = angles.get(2);
        double fourthAngle = angles.get(3);

        ShapeType type = null;
        if (firstAngle == UNFOLDED_ANGLE || secondAngle == UNFOLDED_ANGLE || thirdAngle == UNFOLDED_ANGLE || fourthAngle == UNFOLDED_ANGLE) {
            type = ShapeType.TRIANGLE;
        } else {
            if (firstAngle > UNFOLDED_ANGLE || secondAngle > UNFOLDED_ANGLE || thirdAngle > UNFOLDED_ANGLE || fourthAngle > UNFOLDED_ANGLE) {
                type = ShapeType.NONCONVEX_QUADRILATERAL;
            } else {
                type = ShapeType.CONVEX_QUADRILATERAL;
                if ((firstAngle + fourthAngle == UNFOLDED_ANGLE && firstAngle + secondAngle != UNFOLDED_ANGLE) || (firstAngle + secondAngle == UNFOLDED_ANGLE && firstAngle + fourthAngle != UNFOLDED_ANGLE)) {
                    type = ShapeType.TRAPEZIUM;
                } else {
                    if (firstAngle == thirdAngle) {
                        type = ShapeType.RHOMBUS;
                        if (firstAngle == UNFOLDED_ANGLE / 2 && thirdAngle == UNFOLDED_ANGLE / 2) {
                            type = ShapeType.SQUARE;
                        }
                    }
                }
            }
        }
        log.info("Type was defined as " + type);
        return type;
    }

    public double calculateArea(Quadrilateral quadrilateral) {
        double area = 0;
        switch (defineTypeOfQuadrilateral(quadrilateral)) {
            case SQUARE:
            case RHOMBUS:
            case TRAPEZIUM:
            case NONCONVEX_QUADRILATERAL:
            case CONVEX_QUADRILATERAL:
                area = calculateQuadrilateralArea(quadrilateral);
                break;
            case TRIANGLE:
                area = calculateTriangleArea(quadrilateral);
                break;
        }
        log.info("Area was calculated , value = " + area);
        return area;
    }

    public double calculatePerimetr(Quadrilateral quadrilateral) {
        List<Double> sidesLingth = getSidesLength(quadrilateral);
        double perimetr = 0;
        for (Double lenth : sidesLingth) {
            perimetr += lenth;
        }
        log.info("Perimetr was calculated , value = " + perimetr);
        return perimetr;
    }

    private double calculateTriangleArea(Quadrilateral quadrilateral) {

        List<Point> points = quadrilateral.getPoints();
        Point first = points.get(0);
        Point second = points.get(1);
        Point third = points.get(2);
        Point fourth = points.get(3);

        List<Double> angles = getAngles(points);

        double angle = 0;
        double firstSide = 0;
        double secondSiade = 0;

        if (angles.get(0) == UNFOLDED_ANGLE) {
            angle = angles.get(1);
            firstSide = getDistance(fourth, second);
            secondSiade = getDistance(second, third);
        }
        if (angles.get(1) == UNFOLDED_ANGLE) {
            angle = angles.get(0);
            firstSide = getDistance(first, third);
            secondSiade = getDistance(first, fourth);
        }
        if (angles.get(2) == UNFOLDED_ANGLE) {
            angle = angles.get(0);
            firstSide = getDistance(first, second);
            secondSiade = getDistance(first, fourth);
        }
        if (angles.get(3) == UNFOLDED_ANGLE) {
            angle = angles.get(0);
            firstSide = getDistance(first, third);
            secondSiade = getDistance(first, second);
        }

        double area = firstSide * secondSiade * Math.sin(Math.toRadians(angle)) / 2;
        return area;
    }

    private double calculateQuadrilateralArea(Quadrilateral quadrilateral) {
        List<Point> points = quadrilateral.getPoints();
        Point first = points.get(0);
        Point second = points.get(1);
        Point third = points.get(2);
        Point fourth = points.get(3);

        double firstDiagonal = getDistance(first, third);
        double secondDiagonal = getDistance(second, fourth);

        Point diadonalCrossPoint = getCrossPoint(first, second, third, fourth);

        double angle = Math.toDegrees(getAngelBetweenPoints(first, diadonalCrossPoint, second));
        if (angle > UNFOLDED_ANGLE / 2) {
            angle = Math.abs(angle - UNFOLDED_ANGLE);
        }

        double area = firstDiagonal * secondDiagonal * Math.sin(Math.toRadians(angle)) / 2;
        return area;
    }

    private List<Double> getAngles(List<Point> points) {
        Point first = points.get(0);
        Point second = points.get(1);
        Point third = points.get(2);
        Point fourth = points.get(3);

        double firstAngle = Math.toDegrees(getAngelBetweenPoints(fourth, first, second));
        double secondAngle = Math.toDegrees(getAngelBetweenPoints(first, second, third));
        double thirdAngle = Math.toDegrees(getAngelBetweenPoints(second, third, fourth));
        double fourthAngle = Math.toDegrees(getAngelBetweenPoints(third, fourth, first));

        List<Double> angles = new ArrayList<>() {
        };

        angles.add(firstAngle > UNFOLDED_ANGLE ? Math.abs(firstAngle - UNFOLDED_ANGLE * 2) : firstAngle);
        angles.add(secondAngle > UNFOLDED_ANGLE ? Math.abs(secondAngle - UNFOLDED_ANGLE * 2) : secondAngle);
        angles.add(thirdAngle > UNFOLDED_ANGLE ? Math.abs(thirdAngle - UNFOLDED_ANGLE * 2) : thirdAngle);
        angles.add(fourthAngle > UNFOLDED_ANGLE ? Math.abs(fourthAngle - UNFOLDED_ANGLE * 2) : fourthAngle);
        return angles;
    }

    private List<Double> getSidesLength(Quadrilateral quadrilateral) {
        List<Point> points = quadrilateral.getPoints();

        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        Point thirdPoint = points.get(2);
        Point fourthPoint = points.get(3);

        List<Double> sidesLingth = new ArrayList<Double>();

        sidesLingth.add(getDistance(firstPoint, secondPoint));
        sidesLingth.add(getDistance(secondPoint, thirdPoint));
        sidesLingth.add(getDistance(thirdPoint, fourthPoint));
        sidesLingth.add(getDistance(fourthPoint, firstPoint));

        return sidesLingth;
    }

    private double getDistance(Point firstPoint, Point secondPoint) {
        double firstX = firstPoint.getX();
        double secondX = secondPoint.getX();

        double firstY = firstPoint.getY();
        double secondY = secondPoint.getY();

        double firstSideLength = Math.abs(firstX - secondX);
        double secondSideLength = Math.abs(firstY - secondY);

        double firstSideSquare = Math.pow(firstSideLength, 2);
        double secondSideSquare = Math.pow(secondSideLength, 2);

        return Math.abs(Math.sqrt(firstSideSquare + secondSideSquare));
    }

    private double getAngelBetweenPoints(Point first, Point second, Point third) {
        double firstX = first.getX();
        double firstY = first.getY();
        double secondX = second.getX();
        double secondY = second.getY();
        double thirdX = third.getX();
        double thirdY = third.getY();


        double angle1 = Math.atan2(firstY - secondY, firstX - secondX);
        double angle2 = Math.atan2(thirdY - secondY, thirdX - secondX);
        return Math.abs(angle1 - angle2);
    }

    private Point getCrossPoint(Point first, Point second, Point third, Point fourth) {
        double z1 = getDistance(fourth, second) * getDistance(fourth, first) * Math.sin(getAngelBetweenPoints(first, fourth, second));
        double z2 = getDistance(fourth, second) * getDistance(fourth, third) * Math.sin(Math.abs(getAngelBetweenPoints(second, fourth, third) - 6.28318));

        double crossX = first.getX() + (third.getX() - first.getX()) * Math.abs(z1) / Math.abs(z2 - z1);
        double crossY = first.getY() + (third.getY() - first.getY()) * Math.abs(z1) / Math.abs(z2 - z1);

        return new Point(crossX, crossY);
    }

    public double roundToDischarge(double value, int afterpoint) {
        value = value * Math.pow(10, afterpoint);
        int i = (int) Math.round(value);
        value = (double) i / Math.pow(10, afterpoint);
        return value;
    }
}
