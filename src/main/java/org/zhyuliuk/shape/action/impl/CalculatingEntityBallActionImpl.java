package org.zhyuliuk.shape.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;

public class CalculatingEntityBallActionImpl implements CalculatingEntityBallAction {
    private static final Logger logger = LogManager.getLogger();
    private static CalculatingEntityBallActionImpl instance ;
    private CalculatingEntityBallActionImpl() {
    }

    public static CalculatingEntityBallActionImpl getInstance() {
        if (instance == null) {
            instance = new CalculatingEntityBallActionImpl();
        }
        return instance;
    }

    public double calculateSurfaceArea(EntityBall entityBall) throws ShapesException {
        return 4 * Math.PI * Math.pow(entityBall.getRadius(), 2);
    }

    public double calculateVolumeBall(EntityBall entityBall) throws ShapesException {
        return 4 * Math.PI * Math.pow(entityBall.getRadius(), 3) / 3;
    }


    private double calculateSegmentVolume(EntityBall sphere, double h) throws ShapesException {
        if (!isSphere(sphere)) throw new ShapesException("Can't calculate segment volume for non sphere object.");

        return (Math.PI * Math.pow(h, 2) * (sphere.getRadius() - h / 3));
    }
    public double relationOxy(EntityBall sphere) throws ShapesException {
        double absZ = Math.abs(sphere.getPointCenter().getZ());
        double radius = sphere.getRadius();

        if (radius <= absZ) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absZ);
        double volumeSecondSegment = calculateVolumeBall(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOxz(EntityBall sphere) throws ShapesException {
        double absY = Math.abs(sphere.getPointCenter().getY());
        double radius = sphere.getRadius();

        if (radius <= absY) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absY);
        double volumeSecondSegment = calculateVolumeBall(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOyz(EntityBall sphere) throws ShapesException {
        double absX = Math.abs(sphere.getPointCenter().getX());
        double radius = sphere.getRadius();

        if (radius <= absX) return 0;

        double volumeFirstSegment = calculateSegmentVolume(sphere, radius - absX);
        double volumeSecondSegment = calculateVolumeBall(sphere) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }
    public boolean isBallTouchesCoordinatePlanes(EntityBall entityBall) {
        return Math.abs(entityBall.getPointCenter().getX()) == entityBall.getRadius() ||
                Math.abs(entityBall.getPointCenter().getY()) == entityBall.getRadius() ||
                Math.abs(entityBall.getPointCenter().getZ()) == entityBall.getRadius();
    }
    public boolean isSphere(Object o){
        if(!(o instanceof EntityBall)){
            return false;
        }

        EntityBall sphere = (EntityBall) o;

        return (sphere.getRadius() != 0);
    }
}