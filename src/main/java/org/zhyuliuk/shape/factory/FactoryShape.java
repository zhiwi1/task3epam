package org.zhyuliuk.shape.factory;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.entity.impl.Point;
import org.zhyuliuk.shape.parser.impl.BallParameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class FactoryShape {

    public EntityBall createShape(String name, Point point, double radius) {
        return new EntityBall(name, point, radius);
    }

    public EntityBall createShape(String name, double x, double y, double z, double radius) {
        return new EntityBall(name, new Point(x, y, z), radius);
    }
    public EntityBall createShape(String name, BallParameter parameter){
        return new EntityBall(name,new Point(parameter.getX(),parameter.getY(), parameter.getZ()), parameter.getRadius());

    }
    public List<EntityBall> balls(HashMap<String,BallParameter> map){
        String[] keys=(String[])  map.keySet().stream().toArray();
        List<BallParameter> parameters=new ArrayList<>(map.values());
      ArrayList<EntityBall> balls=new ArrayList<>();
        for (int i=0;i<keys.length;i++){
            balls.add(new EntityBall(keys[i],new Point(parameters.get(i).getX(),parameters.get(i).getY(),
                    parameters.get(i).getZ()),parameters.get(i).getRadius()));
        }
        return balls;
    }
}