package org.zhyuliuk.shape.repository;

import org.testng.Assert;
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
    BallRepository repository = BallRepositoryImpl.getInstance();
    FactoryShape factoryShape = new FactoryShape();

    @Test
    public void querySpecificationByXTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationByCoordinateXCenter(1);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByYTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationByCoordinateYCenter(1);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByDistanceFromCenterTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 3, 4, 12, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationByDistanceFromCenter(13);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByNameTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 3, 4, 12, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationByName("name");
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationBySurfaceAreaTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 1);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 3, 4, 12, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationBySurfaceArea(1, 15);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void querySpecificationByVolumeTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 1, 2, 3, 1);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 3, 4, 12, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        FindSpecification findSpecification = new FindSpecificationByVolume(1, 15);
        List<EntityBall> actualBallList = repository.query(findSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallThird);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

    @Test
    public void sortingSpecificationByXTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 3, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        BallComparator sortSpecification = new SortSpecificationByCoordinateXCenter();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallSecond);
        expectedBallList.add(entityBallFirst);
        Assert.assertEquals(actualBallList, expectedBallList);
    }
    @Test
    public void sortingSpecificationByYTest() {
        EntityBall entityBallFirst = factoryShape.createShape("name", 3, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
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
        EntityBall entityBallFirst = factoryShape.createShape("name", 3, 2, 3, 1);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 1);
        EntityBall entityBallThird = factoryShape.createShape("name3", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
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
        EntityBall entityBallFirst = factoryShape.createShape("name3", 3, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        BallComparator sortSpecification = new SortSpecificationByName();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallSecond);
        expectedBallList.add(entityBallFirst);
        Assert.assertEquals(actualBallList, expectedBallList);
    }
    @Test
    public void sortingSpecificationBySurfaceArea() {
        EntityBall entityBallFirst = factoryShape.createShape("name3", 3, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
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
        EntityBall entityBallFirst = factoryShape.createShape("name3", 3, 2, 3, 4);
        EntityBall entityBallSecond = factoryShape.createShape("name2", 2, 3, 4, 5);
        EntityBall entityBallThird = factoryShape.createShape("name", 1, 1, 1, 1);
        BallRepository repository = BallRepositoryImpl.getInstance();
        repository.addBall(entityBallFirst);
        repository.addBall(entityBallSecond);
        repository.addBall(entityBallThird);
        BallComparator sortSpecification = new SortSpecificationByVolume();
        List<EntityBall> actualBallList = repository.sorting(sortSpecification);
        List<EntityBall> expectedBallList = new ArrayList<>();
        expectedBallList.add(entityBallThird);
        expectedBallList.add(entityBallFirst);
        expectedBallList.add(entityBallSecond);
        Assert.assertEquals(actualBallList, expectedBallList);
    }

}
