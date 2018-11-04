package com.emap.geometry.repository.spesifications;

import com.emap.geometry.entities.Quadrilateral;

public class IdSpesification implements Spesification<Quadrilateral> {
       private long id;

    public IdSpesification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Quadrilateral o) {
        return id == o.getId();
    }
}
