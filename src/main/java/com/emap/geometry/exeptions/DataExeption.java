package com.emap.geometry.exeptions;

public class DataExeption extends Exception {
    public DataExeption(String msg, Exception exception) {
        super(msg, exception);
    }
}
