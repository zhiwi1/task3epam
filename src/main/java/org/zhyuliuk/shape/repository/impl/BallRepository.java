package org.zhyuliuk.shape.repository.impl;

import org.zhyuliuk.shape.entity.ShapeInterface;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.repository.BallRepositoryInterface;
import org.zhyuliuk.shape.specification.find.FindSpecificationInterface;
import org.zhyuliuk.shape.specification.sort.SortSpecificationInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallRepository implements BallRepositoryInterface {

    private List<EntityBall> entityBallList;

    public BallRepository() {
        entityBallList = new ArrayList<>();
    }

    public BallRepository(List<EntityBall> entityBallList) {
        this.entityBallList = new ArrayList<>(entityBallList);
    }

    public List<EntityBall> getEntityBallList() {
        return new ArrayList<>(entityBallList);
    }



    @Override
    public void addBall(EntityBall ball) {
        entityBallList.add(ball);
    }

    @Override
    public void removeBall(EntityBall ball) {
        entityBallList.remove(ball);
    }


    @Override
    public void updateBall(int position, EntityBall ball) {
        if (position >= 0 && position < entityBallList.size()) {
            entityBallList.add(position, ball);
        }

    }

    @Override
    public List query(FindSpecificationInterface specification) {
        ArrayList<EntityBall> list = new ArrayList<>();
        for (EntityBall ball : entityBallList) {
            if (specification.specified(ball)) {
                list.add(ball);
            }
        }
        return list;
    }
    @Override
    public void sorting(SortSpecificationInterface sortSpecification) {
        //Stream need
//        entityBallList.stream().sorted(sortSpecification);
        Collections.sort(entityBallList,sortSpecification);
    }
}