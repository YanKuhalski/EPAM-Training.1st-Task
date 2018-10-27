package com.emap.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findBy(Spesification<T> spesification);
    void add(T entitie);
    void remove (T entitie);
    void update (T entitie);
}
