package org.zhyuliuk.shape.repository;


import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecification;
import org.zhyuliuk.shape.specification.sort.SortSpecification;

import java.util.List;

public interface BallRepository {

    public void addBall(EntityBall ball);

    public void removeBall(EntityBall ball);

    public void updateBall(int position,EntityBall ball);

    public List query(FindSpecification specification);

    public void sorting(SortSpecification sortSpecification);

}