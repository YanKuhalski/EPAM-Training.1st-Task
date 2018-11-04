package com.emap.geometry.repository;

import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.spesifications.Spesification;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class QuadrilateralRepository implements  SortableRepository<Quadrilateral> {
    private Map<Long, Quadrilateral> data = new HashMap<>();
    private final static Logger log = Logger.getLogger(QuadrilateralRepository.class);

    @Override
    public void add(Quadrilateral entitie) {
        data.put(entitie.getId(), entitie);
        log.info("Quadrilateral with ID " + entitie.getId() + " was added to the repository");
    }

    @Override
    public void remove(Quadrilateral entitie) {
        data.remove(entitie.getId());
        log.info("Quadrilateral with ID " + entitie.getId() + " was removed from repository");
    }

    @Override
    public void update(Quadrilateral entitie) {
        long id = entitie.getId();
        data.replace(id, entitie);
        log.info("Quadrilateral with ID " + entitie.getId() + " was update");
    }

    @Override
    public List<Quadrilateral> findBy(Spesification<Quadrilateral> spesification) {
        List<Quadrilateral> result = data.values().stream().filter(o -> spesification.specified(o)).collect(Collectors.toList());
        log.info("Finding using " + spesification.getClass().getSimpleName() + " specification gave " + result.size() + " results");
        return result;
    }


    @Override
    public Set<Quadrilateral> sortValues(Comparator<Quadrilateral> comparator) {
        Set<Quadrilateral> quadrilaterals = new TreeSet<>(comparator);
        quadrilaterals.addAll(data.values());
        return quadrilaterals;
    }
}
