package org.zhyuliuk.shape.warehouse;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.factory.FactoryShape;
import org.zhyuliuk.shape.observer.impl.BallObserver;

public class WarehouseTest {
    @Test
    public void putParametersWithChangedRadiusTest() throws ShapesException {
        FactoryShape factory=new FactoryShape();
        CalculatingEntityBallAction action = CalculatingEntityBallActionImpl.getInstance();
        EntityBall ball=factory.createShape("name",1,2,3,4);
        BallObserver observer=new BallObserver();
        ball.attach(observer);
        double volume=action.calculateVolumeBall(ball);
        double surfaceArea=action.calculateSurfaceArea(ball);
        WareHouse wareHouse=WareHouse.getInstance();
        wareHouse.putParameters(ball.getName(),volume,surfaceArea);
        ball.setRadius(1);
        Assert.assertEquals(wareHouse.getParameters(ball.getName()),new BallProperties(4*Math.PI/3,4*Math.PI));
    }
    @Test
    public void updateParametersTest() throws ShapesException{
        FactoryShape factory=new FactoryShape();
        CalculatingEntityBallAction action = CalculatingEntityBallActionImpl.getInstance();
        EntityBall ball=factory.createShape("name",1,2,3,4);
        double volume=action.calculateVolumeBall(ball);
        double surfaceArea=action.calculateSurfaceArea(ball);
        WareHouse wareHouse=WareHouse.getInstance();
        wareHouse.putParameters(ball.getName(),volume,surfaceArea);
        wareHouse.updateParameters(ball.getName(),1,5);
        Assert.assertEquals(wareHouse.getParameters(ball.getName()),new BallProperties(1,5));
    }
}
