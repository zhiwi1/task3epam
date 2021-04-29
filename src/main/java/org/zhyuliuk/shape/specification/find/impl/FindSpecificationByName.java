package org.zhyuliuk.shape.specification.find.impl;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecification;

public class FindSpecificationByName implements FindSpecification {
    private String desiredBallName;

    public FindSpecificationByName(String desiredName) {
        super();
        this.desiredBallName = desiredName;
    }

    @Override
    public boolean specified(EntityBall ball) {
        return desiredBallName.equals(ball.getName());
    }
}
