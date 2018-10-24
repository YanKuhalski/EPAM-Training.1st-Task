package com.emap.exeptions;

public class DataExeption extends Exception {
    public DataExeption(String message) {
        super(message);
    }

    public DataExeption(String msg, Exception exception) {
        super(msg, exception);
    }
}
