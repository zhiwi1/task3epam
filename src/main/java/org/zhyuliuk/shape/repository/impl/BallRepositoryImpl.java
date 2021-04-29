package org.zhyuliuk.shape.repository.impl;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.repository.BallRepository;
import org.zhyuliuk.shape.specification.find.FindSpecification;
import org.zhyuliuk.shape.specification.sort.SortSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallRepositoryImpl implements org.zhyuliuk.shape.repository.BallRepository {
    //singleton названия не забыть
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
    public List query(FindSpecification specification) {
        ArrayList<EntityBall> list = new ArrayList<>();
        for (EntityBall ball : entityBallList) {
            if (specification.specified(ball)) {
                list.add(ball);
            }
        }
        return list;
    }
    @Override
    public void sorting(SortSpecification comparator) {
        //Stream need
//        entityBallList.stream().sorted(comparator);
        Collections.sort(entityBallList,comparator);
    }
}