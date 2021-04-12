package org.zhyuliuk.shape.specification.find.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecificationInterface;

public class FindSpecificationByDistanceFromCenter implements FindSpecificationInterface {
    private final static Logger logger = LogManager.getLogger();
    private double distance;
    public FindSpecificationByDistanceFromCenter(double desiredDistance) {
        super();
        this.distance = desiredDistance;

    }
    @Override
    public boolean specified(EntityBall ball) {
        double distance=Math.sqrt(Math.pow(ball.getPointCenter().getX(),2)+Math.pow(ball.getPointCenter().getY(),2)+Math.pow(ball.getPointCenter().getZ(),2));

        return distance<this.distance;
    }
}
