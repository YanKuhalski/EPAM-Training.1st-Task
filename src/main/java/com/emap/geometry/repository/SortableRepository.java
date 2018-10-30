package com.emap.geometry.repository;

import java.util.Comparator;
import java.util.Set;

public interface SortableRepository<T> extends Repository<T> {
    Set<T> sortValues(Comparator<T> comparator);
}
