package com.emap.geometry.register;

import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;

import java.util.List;

public class ObservableQuadrilateral extends Quadrilateral implements Observable {
    private Observer<ObservableQuadrilateral> observer;

    public ObservableQuadrilateral(Quadrilateral quadrilateral, long id) {
        super(quadrilateral.getPoints(), id);
    }

    public ObservableQuadrilateral(List<Point> points, long id) {
        super(points, id);
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
        if (observer != null) {
            observer.update(this);
        }
    }

    public void setPoins(List<Point> newPoints) {
        super.points = newPoints;
        notifyObserver();
    }
}
