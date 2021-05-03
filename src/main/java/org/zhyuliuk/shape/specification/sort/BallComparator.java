package org.zhyuliuk.shape.specification.sort;

import org.zhyuliuk.shape.entity.EntityBall;

import java.util.Comparator;

public interface BallComparator extends Comparator<EntityBall> {
    public int compare(EntityBall firstBall, EntityBall secondBall);

}
