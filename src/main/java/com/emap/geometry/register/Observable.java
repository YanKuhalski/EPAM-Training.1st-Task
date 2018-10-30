package com.emap.geometry.register;

public interface Observable {
    void addObserver();

    void removeObserver();

    void notifyObserver();
}
