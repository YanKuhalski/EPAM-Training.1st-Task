package com.emap.geometry.creation;

public class IDGenerator {
    private static long quadrilateralID = 0;

    public static long generateQuadrilateralID() {
        return quadrilateralID++;
    }
}
