package org.zhyuliuk.shape.specification.find.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.find.FindSpecification;

public class FindSpecificationBySurfaceArea implements FindSpecification {
    private final static Logger logger = LogManager.getLogger();
    private double minDesiredArea;
    private double maxDesiredArea;

    public FindSpecificationBySurfaceArea(int desiredAreaMin, int desiredAreaMax) {
        super();
        this.minDesiredArea = desiredAreaMin;
        this.maxDesiredArea = desiredAreaMax;
    }


    @Override
    public boolean specified(EntityBall entityBall) {
        double area = 0;
        try {
            CalculatingEntityBallActionImpl calculatingEntityBallAction = CalculatingEntityBallActionImpl.getInstance();
            area = calculatingEntityBallAction.calculateVolumeBall(entityBall);
        } catch (ShapesException exception) {
            logger.log(Level.INFO, "exception in calculating area in " + entityBall);
        }
        return (area >= minDesiredArea) && (area <= maxDesiredArea);
    }
}
