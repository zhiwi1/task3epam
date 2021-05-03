package org.zhyuliuk.shape.specification.sort.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.sort.BallComparator;

public class SortSpecificationByCoordinateXCenter implements BallComparator {
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        int result=0;
        double firstX=firstBall.getPointCenter().getX();
        double secondX=secondBall.getPointCenter().getX();
        if (firstX > secondX) {
            result = 1;
        } else if (firstX < secondX) {
            result = -1;
        }
        return result;
    }
}
