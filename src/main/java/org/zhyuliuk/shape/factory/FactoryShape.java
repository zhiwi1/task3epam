package org.zhyuliuk.shape.factory;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.entity.Point;
import org.zhyuliuk.shape.parser.BallParameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FactoryShape {

    public EntityBall createShape(String name, Point point, double radius) {
        return new EntityBall(name, point, radius);
    }

    public EntityBall createShape(String name, double x, double y, double z, double radius) {
        return new EntityBall(name, new Point(x, y, z), radius);
    }

    public EntityBall createShape(String name, BallParameter parameter) {
        return new EntityBall(name, new Point(parameter.getX(), parameter.getY(), parameter.getZ()), parameter.getRadius());

    }

    public List<EntityBall> createBalls(HashMap<String, BallParameter> map) {
        List<String> keys = new ArrayList<>(map.keySet());
        List<BallParameter> parameters = new ArrayList<>(map.values());
        ArrayList<EntityBall> balls = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            balls.add(new EntityBall(keys.get(i), new Point(parameters.get(i).getX(), parameters.get(i).getY(),
                    parameters.get(i).getZ()), parameters.get(i).getRadius()));
        }
        return balls;
    }
}