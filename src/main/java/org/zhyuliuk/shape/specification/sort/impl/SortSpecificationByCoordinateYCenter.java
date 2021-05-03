package org.zhyuliuk.shape.specification.sort.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.sort.BallComparator;

public class SortSpecificationByCoordinateYCenter implements BallComparator {
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        int result=0;
        double firstY=firstBall.getPointCenter().getY();
        double secondY=secondBall.getPointCenter().getY();
        if (firstY > secondY) {
            result = 1;
        } else if (firstY < secondY) {
            result = -1;
        }
        return result;
    }
}
