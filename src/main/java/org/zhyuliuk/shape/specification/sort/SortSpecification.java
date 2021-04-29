package org.zhyuliuk.shape.specification.sort;

import org.zhyuliuk.shape.entity.impl.EntityBall;

import java.util.Comparator;

public interface SortSpecification extends Comparator<EntityBall> {
    public int compare(EntityBall firstBall, EntityBall secondBall);

}
