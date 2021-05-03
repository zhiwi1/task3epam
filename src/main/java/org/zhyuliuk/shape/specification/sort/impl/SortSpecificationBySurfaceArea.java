package org.zhyuliuk.shape.specification.sort.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.sort.BallComparator;

public class SortSpecificationBySurfaceArea implements BallComparator {
    private final static Logger logger= LogManager.getLogger();
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        int result = 0;
        CalculatingEntityBallAction calculatingEntityBallAction = CalculatingEntityBallActionImpl.getInstance();
        try {
            double firstArea = calculatingEntityBallAction.calculateSurfaceArea(firstBall);
            double secondArea = calculatingEntityBallAction.calculateSurfaceArea(secondBall);
            if (firstArea > secondArea) {
                result = 1;
            } else if (firstArea < secondArea) {
                result = -1;
            }
        }catch (ShapesException exception){
            logger.log(Level.INFO,exception.getMessage());
        }
        return result;

    }
}
