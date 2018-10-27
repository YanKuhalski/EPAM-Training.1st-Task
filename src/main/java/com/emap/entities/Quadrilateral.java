package com.emap.entities;

import com.emap.register.Observable;
import com.emap.register.Observer;
import com.emap.register.Register;

import java.util.ArrayList;
import java.util.List;

public class Quadrilateral implements Observable {
    private long id;
    private Observer<Quadrilateral> observer;
    private List<Point> points;

    public Quadrilateral(List<Point> points, long id) {
        this.points = new ArrayList<>(points);
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }


    public void setPoins(List<Point> newPoints) {
        points = newPoints;
        notifyObserver();
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quadrilateral:" + id + " \n");
        for (Point point : points) {
            sb.append("         " + point + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Quadrilateral that = (Quadrilateral) o;

        for (int i = 0; i < 4; i++) {
            if (!(getPoints().get(i).equals(that.getPoints().get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getPoints() != null ? getPoints().hashCode() : 0;
    }

    @Override
    public void addObserver() {
        observer = Register.getInstance();
        observer.update(this);
    }

    @Override
    public void removeObserver() {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }
}
