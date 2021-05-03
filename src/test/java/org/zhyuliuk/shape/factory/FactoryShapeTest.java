package org.zhyuliuk.shape.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.entity.Point;
import org.zhyuliuk.shape.parser.impl.BallParameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FactoryShapeTest {
    private final static Logger logger = LogManager.getLogger();
    FactoryShape factory = new FactoryShape();

    @Test
    public void createShapeTestFirst() {
        String name = "name";
        Point point = new Point(1, 2, 3);
        int radius = 4;
        EntityBall actualBall = factory.createShape(name, point, radius);
        EntityBall expectedBall = new EntityBall(name, point, radius);
        Assert.assertEquals(actualBall, expectedBall);
    }

    @Test
    public void createShapeTestSecond() {
        String name = "name";
        int x = 1;
        int y = 2;
        int z = 3;
        int radius = 4;
        EntityBall actualBall = factory.createShape(name, 1, 2, 3, radius);
        EntityBall expectedBall = new EntityBall(name, new Point(1, 2, 3), radius);
        Assert.assertEquals(actualBall, expectedBall);
    }

    @Test
    public void createShapeTestThird() {
        String name = "name";
        int x = 1;
        int y = 2;
        int z = 3;
        int radius = 4;
        BallParameter parameter = new BallParameter(x, y, z, radius);
        EntityBall actualBall = factory.createShape(name, parameter);
        EntityBall expectedBall = new EntityBall(name, new Point(1, 2, 3), radius);
        Assert.assertEquals(actualBall, expectedBall);
    }

    @Test
    public void createBallsTest() {
        HashMap<String, BallParameter> map = new HashMap<>();
        map.put("name1", new BallParameter(1, 2, 3, 4));
        map.put("name0", new BallParameter(2, 3, 4, 5));
        List<EntityBall> actualBallList = factory.createBalls(map);
        List <EntityBall> expectedBallList=new ArrayList<>();
        expectedBallList.add(factory.createShape("name1",new BallParameter(1, 2, 3, 4)));
        expectedBallList.add(factory.createShape("name0",new BallParameter(2, 3, 4, 5)));
        Assert.assertEquals(actualBallList,expectedBallList);

    }
}