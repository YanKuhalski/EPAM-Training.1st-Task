package com.epam.geometry.repository;

import com.emap.geometry.creation.IDGenerator;
import com.emap.geometry.entities.Point;
import com.emap.geometry.entities.Quadrilateral;
import com.emap.geometry.repository.QuadrilateralRepository;
import com.emap.geometry.repository.Repository;
import com.emap.geometry.repository.spesifications.IdSpesification;
import com.emap.geometry.repository.spesifications.Spesification;
import com.emap.geometry.repository.spesifications.AreaSpesification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrilateralRepositoryTest {
    private final static List<Point> POINTS = Arrays.asList(new Point(6, 7),
            new Point(8, 5),
            new Point(2, 1),
            new Point(2, 1));

    @Test
    public void shouldUpdateData() {
        //given
        Repository<Quadrilateral> repository = new QuadrilateralRepository();
        Quadrilateral quadrilateral = new Quadrilateral(POINTS, 1);
        Quadrilateral newQuad = new Quadrilateral(Arrays.asList(new Point(1, 2),
                new Point(8, 5),
                new Point(2, 1),
                new Point(2, 1)),
                1);
        repository.add(quadrilateral);
        //when
        repository.update(newQuad);

        //then
        Assert.assertEquals(Arrays.asList(newQuad), repository.findBy(new IdSpesification(1)));
    }

    @Test
    public void shouldRemoveQuadrilateral() {
        //given
        Repository<Quadrilateral> repository = new QuadrilateralRepository();
        Quadrilateral quadrilateral = new Quadrilateral(POINTS, 1);
        repository.add(quadrilateral);
        //when
        repository.remove(quadrilateral);

        //then
        Assert.assertEquals(new ArrayList<Quadrilateral>(), repository.findBy(new IdSpesification(1)));
    }

    @Test
    public void shouldAddQuadrilateral() {
        //given
        Repository<Quadrilateral> repository = new QuadrilateralRepository();
        Quadrilateral quadrilateral = new Quadrilateral(POINTS, 1);

        //when
        repository.add(quadrilateral);

        //then
        Assert.assertEquals(Arrays.asList(quadrilateral), repository.findBy(new IdSpesification(1)));
    }

    @Test
    public void shouldFindQuadrilateral() {
        //given
        Repository<Quadrilateral> repository = new QuadrilateralRepository();
        Quadrilateral quadrilateral = new Quadrilateral(POINTS, IDGenerator.generateQuadrilateralID());
        repository.add(quadrilateral);
        Spesification<Quadrilateral> spesification = new AreaSpesification(10);

        List<Quadrilateral> expected = Arrays.asList(quadrilateral);
        // when
        List<Quadrilateral> result = repository.findBy(spesification);

        //then
        Assert.assertEquals(expected, result);
    }
}
