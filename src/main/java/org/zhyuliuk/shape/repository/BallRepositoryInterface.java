package org.zhyuliuk.shape.repository;


import org.zhyuliuk.shape.entity.ShapeInterface;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.specification.find.FindSpecificationInterface;
import org.zhyuliuk.shape.specification.sort.SortSpecificationInterface;

import java.util.List;

public interface BallRepositoryInterface {

    public void addBall(EntityBall ball);

    public void removeBall(EntityBall ball);

    public void updateBall(int position,EntityBall ball);

    public List query(FindSpecificationInterface specification);

    public void sorting(SortSpecificationInterface sortSpecification);

}