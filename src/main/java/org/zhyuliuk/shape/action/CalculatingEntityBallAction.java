package org.zhyuliuk.shape.action;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;

public interface CalculatingEntityBallAction {
    public double calculateSurfaceArea(EntityBall entityBall) throws ShapesException;

    public double calculateVolumeBall(EntityBall entityBall) throws ShapesException;

    public double calculateDistanceFromCenter(EntityBall entityBall) throws ShapesException;

    public double calculateRelationOxy(EntityBall sphere) throws ShapesException;

    public double calculateRelationOxz(EntityBall sphere) throws ShapesException;

    public double calculateRelationOyz(EntityBall sphere) throws ShapesException;

    public boolean isBallTouchesCoordinatePlanes(EntityBall entityBall) throws ShapesException;

    public boolean isSphere(Object o);
}
