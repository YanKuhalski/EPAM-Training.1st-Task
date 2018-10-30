package com.emap.geometry.validation;

public class StringValidator {
   private static final String REGEX = "(-?\\d+\\.?\\d+? )+";
    public boolean isValid(String string) {
        return string.matches(REGEX);
    }
}
