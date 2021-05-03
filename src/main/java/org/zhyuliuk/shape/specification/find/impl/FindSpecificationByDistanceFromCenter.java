package org.zhyuliuk.shape.specification.find.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.find.FindSpecification;

public class FindSpecificationByDistanceFromCenter implements FindSpecification {
    private final static Logger logger = LogManager.getLogger();
    private double distance;

    public FindSpecificationByDistanceFromCenter(double desiredDistance) {
        super();
        this.distance = desiredDistance;

    }

    @Override
    public boolean specified(EntityBall ball) {
        CalculatingEntityBallAction calculatingEntityBallAction = CalculatingEntityBallActionImpl.getInstance();
        double distance = 0;
        try {
            distance = calculatingEntityBallAction.calculateDistanceFromCenter(ball);
        } catch (ShapesException e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return distance == this.distance;
    }
}
