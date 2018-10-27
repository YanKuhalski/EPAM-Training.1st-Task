package com.emap.register;

public interface Observable {
    void addObserver();

    void removeObserver();

    void notifyObserver();
}
