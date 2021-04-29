package org.zhyuliuk.shape.action;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;

public interface CalculatingEntityBallAction {
    public double calculateSurfaceArea(EntityBall entityBall) throws ShapesException;
    public double calculateVolumeBall(EntityBall entityBall) throws ShapesException;
    public double relationOxy(EntityBall sphere) throws ShapesException;
    public double relationOxz(EntityBall sphere) throws ShapesException;
    public double relationOyz(EntityBall sphere) throws ShapesException;
    public boolean isBallTouchesCoordinatePlanes(EntityBall entityBall);
    public boolean isSphere(Object o);

}
