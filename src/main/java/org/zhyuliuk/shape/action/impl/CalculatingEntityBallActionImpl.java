package org.zhyuliuk.shape.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.validator.DataValidator;


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
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        return 4 * Math.PI * Math.pow(entityBall.getRadius(), 2);
    }

    public double calculateVolumeBall(EntityBall entityBall) throws ShapesException {
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        return 4 * Math.PI * Math.pow(entityBall.getRadius(), 3) / 3;
    }


    private double calculateSegmentVolume(EntityBall entityBall, double h) throws ShapesException {
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        return (Math.PI * Math.pow(h, 2) * (entityBall.getRadius() - h / 3));
    }
    public double calculateDistanceFromCenter(EntityBall entityBall) throws ShapesException{
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        return Math.sqrt(Math.pow(entityBall.getPointCenter().getX(),2)+Math.pow(entityBall.getPointCenter().getY(),2)+Math.pow(entityBall.getPointCenter().getZ(),2));
    }
    public double relationOxy(EntityBall entityBall) throws ShapesException {
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        double absZ = Math.abs(entityBall.getPointCenter().getZ());
        double radius = entityBall.getRadius();

        if (radius <= absZ) return 0;

        double volumeFirstSegment = calculateSegmentVolume(entityBall, radius - absZ);
        double volumeSecondSegment = calculateVolumeBall(entityBall) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOxz(EntityBall entityBall) throws ShapesException {
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        double absY = Math.abs(entityBall.getPointCenter().getY());
        double radius = entityBall.getRadius();

        if (radius <= absY) return 0;

        double volumeFirstSegment = calculateSegmentVolume(entityBall, radius - absY);
        double volumeSecondSegment = calculateVolumeBall(entityBall) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }

    public double relationOyz(EntityBall entityBall) throws ShapesException {
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
        double absX = Math.abs(entityBall.getPointCenter().getX());
        double radius = entityBall.getRadius();

        if (radius <= absX) return 0;

        double volumeFirstSegment = calculateSegmentVolume(entityBall, radius - absX);
        double volumeSecondSegment = calculateVolumeBall(entityBall) - volumeFirstSegment;

        return (volumeFirstSegment / volumeSecondSegment);
    }
    public boolean isBallTouchesCoordinatePlanes(EntityBall entityBall) throws ShapesException{
        if(!isSphere(entityBall)&&(DataValidator.isBallValid(entityBall))){
            throw new ShapesException(entityBall+"is not valid");
        }
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