package org.zhyuliuk.shape.specification.find.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallAction;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.find.FindSpecificationInterface;

public class FindSpecificationByArea implements FindSpecificationInterface {
    private final static Logger logger = LogManager.getLogger();
    private double minDesiredArea;
    private double maxDesiredArea;

    public FindSpecificationByArea(int desiredAreaMin, int desiredAreaMax) {
        super();
        this.minDesiredArea = desiredAreaMin;
        this.maxDesiredArea = desiredAreaMax;
    }


    @Override
    public boolean specified(EntityBall entityBall) {
        double area = 0;
        try {
            CalculatingEntityBallAction calculatingEntityBallAction = CalculatingEntityBallAction.getInstance();
            area = calculatingEntityBallAction.calculateVolumeBall(entityBall);
        } catch (ShapesException exception) {
            logger.log(Level.INFO, "exception in calculating area in " + entityBall);
        }

        return (area >= minDesiredArea) && (area <= maxDesiredArea);
    }
}
