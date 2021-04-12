package org.zhyuliuk.shape.specification.sort.impl;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.specification.sort.SortSpecificationInterface;

public class SortSpecificationByName implements SortSpecificationInterface {
    @Override
    public int compare(EntityBall firstBall, EntityBall secondBall) {
        return firstBall.getName().compareTo(secondBall.getName());
    }
}
