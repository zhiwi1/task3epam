package org.zhyuliuk.shape.repository;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.factory.FactoryShape;
import org.zhyuliuk.shape.repository.impl.BallRepositoryImpl;
import org.zhyuliuk.shape.specification.find.FindSpecification;
import org.zhyuliuk.shape.specification.find.impl.*;
import org.zhyuliuk.shape.specification.sort.BallComparator;
import org.zhyuliuk.shape.specification.sort.impl.*;

import java.util.ArrayList;
import java.util.List;


public class BallRepositoryTest {
    BallRepository repository;
    FactoryShape factoryShape;
    EntityBall entityBallFirst;
    EntityBall entityBallSecond;
    EntityBall entityBallThird;

    @BeforeClass
    public void SetUp() {
        repository = BallRepositoryImpl.getInstance();
        factoryShape = new FactoryShape();
        entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 4);
        entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
    }

    @Test
    public void querySpecificationByXTest() {
        FindSpecification findSpecification = new FindSpecificationByCoordinateXCenter(1);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByYTest() {
        FindSpecification findSpecification = new FindSpecificationByCoordinateYCenter(1);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByDistanceFromCenterTest() {
        FindSpecification findSpecification = new FindSpecificationByDistanceFromCenter(Math.sqrt(3d));
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByNameTest() {
        FindSpecification findSpecification = new FindSpecificationByName("name");
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationBySurfaceAreaTest() {
        FindSpecification findSpecification = new FindSpecificationBySurfaceArea(1, 500);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByVolumeTest() {
        FindSpecification findSpecification = new FindSpecificationByVolume(1, 500);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByXTest() {
        BallComparator sortSpecification = new SortSpecificationByCoordinateXCenter();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByYTest() {
        BallComparator sortSpecification = new SortSpecificationByCoordinateYCenter();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByDistanceFromCenterTest() {
        BallComparator sortSpecification = new SortSpecificationByDistanceFromCenter();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByName() {
        BallComparator sortSpecification = new SortSpecificationByName();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationBySurfaceArea() {
        BallComparator sortSpecification = new SortSpecificationBySurfaceArea();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByVolume() {
        BallComparator sortSpecification = new SortSpecificationByVolume();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

}
