package org.zhyuliuk.shape.specification.find.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecification;

public class FindSpecificationByCoordinateYCenter implements FindSpecification {
    private double desiredY;

    public FindSpecificationByCoordinateYCenter(double desiredY) {
        super();
        this.desiredY = desiredY;
    }

    @Override
    public boolean specified(EntityBall entityBall) {
        return entityBall.getPointCenter().getY() == desiredY;
    }
}

