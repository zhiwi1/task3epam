package org.zhyuliuk.shape.specification.sort.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.sort.BallComparator;

public class SortSpecificationByDistanceFromCenter implements BallComparator {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        CalculatingEntityBallAction calculatingEntityBallAction = CalculatingEntityBallActionImpl.getInstance();
        int result = 0;
        try {
            double distanceFirst = calculatingEntityBallAction.calculateDistanceFromCenter(firstBall);
            double distanceSecond = calculatingEntityBallAction.calculateDistanceFromCenter(secondBall);
            if (distanceFirst > distanceSecond) {
                result = 1;
            } else if (distanceFirst < distanceSecond) {
                result = -1;
            }
        } catch (ShapesException e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return result;
    }
}
