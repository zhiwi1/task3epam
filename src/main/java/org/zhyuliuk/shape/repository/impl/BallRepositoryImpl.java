package org.zhyuliuk.shape.repository.impl;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.repository.BallRepository;
import org.zhyuliuk.shape.specification.find.FindSpecification;
import org.zhyuliuk.shape.specification.sort.BallComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BallRepositoryImpl implements org.zhyuliuk.shape.repository.BallRepository {
    private static final BallRepository instance = new BallRepositoryImpl();
    private List<EntityBall> entityBallList;

    private BallRepositoryImpl() {
        entityBallList = new ArrayList<>();
    }

    private BallRepositoryImpl(List<EntityBall> entityBallList) {
        this.entityBallList = new ArrayList<>(entityBallList);
    }

    public static BallRepository getInstance() {
        return instance;
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
    public List<EntityBall> query(FindSpecification specification) {
        ArrayList<EntityBall> list = new ArrayList<>();
        for (EntityBall ball : entityBallList) {
            if (specification.specified(ball)) {
                list.add(ball);
            }
        }
        return list;
    }

    @Override
    public List<EntityBall> sorting(BallComparator comparator) {

        return entityBallList.stream().sorted(comparator).collect(Collectors.toList());

    }
}