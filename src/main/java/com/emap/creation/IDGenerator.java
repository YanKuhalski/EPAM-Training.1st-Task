package com.emap.creation;

public class IDGenerator {
    private static long quadrilateralID = 0;
    private static long quadrilateralParametrsID = 0;

    private IDGenerator() {
    }

    public static long generateQuadrilateralID() {
        return quadrilateralID++;
    }

    public static long generateParametrsID() {
        return quadrilateralParametrsID++;
    }
}
