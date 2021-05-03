package org.zhyuliuk.shape.specification.sort.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.sort.BallComparator;

public class SortSpecificationByName implements BallComparator {
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        return firstBall.getName().compareTo(secondBall.getName());
    }
}
