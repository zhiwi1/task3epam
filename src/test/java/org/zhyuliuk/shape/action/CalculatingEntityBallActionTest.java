package org.zhyuliuk.shape.action;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallAction;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.entity.impl.EntityPoint;
import org.zhyuliuk.shape.exception.ShapesException;

public class CalculatingEntityBallActionTest {
    private final static CalculatingEntityBallActionInterface calculatingEntityBallAction = CalculatingEntityBallAction.getInstance();

    private final static EntityBall entityBall = new EntityBall("name",new EntityPoint(0,0,0),1) ;

    @Test
    public void calculateSurfaceAreaTest() throws ShapesException {
        double expectedArea = 4 * Math.PI;
        double actualArea = calculatingEntityBallAction.calculateSurfaceArea((EntityBall) entityBall);
        Assert.assertEquals(actualArea, expectedArea);
    }

    @Test
    public void calculateVolumeBallTest() throws ShapesException {
        double expectedVolume = 4 * Math.PI / 3;
        double actualVolume = calculatingEntityBallAction.calculateVolumeBall((EntityBall) entityBall);
        Assert.assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void isBallTouchesCoordinatePlanesTest() throws ShapesException {
        boolean actualRelation = calculatingEntityBallAction.isBallTouchesCoordinatePlanes((EntityBall) entityBall);
        Assert.assertFalse(actualRelation);
    }

    @Test
    public void isSphereTest() throws ShapesException {
        boolean calculatingEntityBallActionSphere = calculatingEntityBallAction.isSphere(entityBall);
        Assert.assertTrue(calculatingEntityBallActionSphere);
    }
}
