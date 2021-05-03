package org.zhyuliuk.shape.specification.find.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecification;

public class FindSpecificationByCoordinateXCenter implements FindSpecification {
    private double desiredX;

    public FindSpecificationByCoordinateXCenter(double desiredX) {
        super();
        this.desiredX = desiredX;
    }

    @Override
    public boolean specified(EntityBall entityBall) {
        return entityBall.getPointCenter().getX() == desiredX;
    }
}
