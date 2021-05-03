package org.zhyuliuk.shape.warehouse;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.factory.FactoryShape;
import org.zhyuliuk.shape.observer.impl.BallObserver;

public class WarehouseTest {
    FactoryShape factory;
    CalculatingEntityBallAction action;
    EntityBall ball;
    double volume;
    double surfaceArea;
    WareHouse wareHouse;

    @BeforeClass
    public void setUp() throws ShapesException {
        factory = new FactoryShape();
        action = CalculatingEntityBallActionImpl.getInstance();
        ball = factory.createShape("name", 1, 2, 3, 4);
        volume = action.calculateVolumeBall(ball);
        action.calculateSurfaceArea(ball);
        wareHouse = WareHouse.getInstance();
        wareHouse.putProperties(ball.getName(), volume, surfaceArea);
    }

    @Test
    public void putPropertiesWithChangedRadiusTest() throws ShapesException {
        BallObserver observer = new BallObserver();
        ball.attach(observer);
        ball.setRadius(1);
        ball.detach(observer);
        BallProperties actual = wareHouse.getProperties(ball.getName());
        BallProperties expected = new BallProperties(4 * Math.PI / 3, 4 * Math.PI);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updatePropertiesTest() throws ShapesException {
        wareHouse.updateProperties(ball.getName(), 1, 5);
        BallProperties actual = wareHouse.getProperties(ball.getName());
        BallProperties expected = new BallProperties(1, 5);
        Assert.assertEquals(actual, expected);
    }

}
