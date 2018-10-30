package com.emap.geometry.repository.spesifications;

import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.Spesification;

public class IDSpesification implements Spesification<Quadrilateral> {
    private long id;

    public IDSpesification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Quadrilateral o) {
        return id == o.getId();
    }
}
