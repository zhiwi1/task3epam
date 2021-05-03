package org.zhyuliuk.shape.repository;


import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecification;
import org.zhyuliuk.shape.specification.sort.BallComparator;

import java.util.List;

public interface BallRepository {

    public void addBall(EntityBall ball);

    public void removeBall(EntityBall ball);

    public void updateBall(int position, EntityBall ball);

    public List<EntityBall> query(FindSpecification specification);

    public List<EntityBall> sorting(BallComparator sortSpecification);

}