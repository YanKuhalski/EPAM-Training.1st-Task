package com.emap.geometry.repository;

import com.emap.geometry.repository.spesifications.Spesification;

import java.util.List;

public interface Repository<T> {
    List<T> findBy(Spesification<T> spesification);
    void add(T entitie);
    void remove (T entitie);
    void update (T entitie);
}
