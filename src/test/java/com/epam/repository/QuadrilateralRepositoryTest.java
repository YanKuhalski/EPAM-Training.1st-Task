package com.epam.repository;

import com.emap.creation.IDGenerator;
import com.emap.entities.Point;
import com.emap.entities.Quadrilateral;
import com.emap.repository.QuadrilateralRepository;
import com.emap.repository.Repository;
import com.emap.repository.Spesification;
import com.emap.repository.spesifications.AreaSpesification;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrilateralRepositoryTest {


    @Test
    public void shouldFindByArea() {
        //given
        Repository<Quadrilateral> repository = new QuadrilateralRepository();
        Quadrilateral quadrilateral = new Quadrilateral(
                Arrays.asList(new Point(6, 7),
                        new Point(8, 5),
                        new Point(2, 1),
                        new Point(2, 1)),
                IDGenerator.generateQuadrilateralID());

        repository.add(quadrilateral);
        Spesification<Quadrilateral> spesification = new AreaSpesification(10);


        List<Quadrilateral> expected = Arrays.asList(quadrilateral);
        // when
        List<Quadrilateral> result = repository.findBy(spesification);

        //then
        Assert.assertEquals(expected, result);
    }
}
