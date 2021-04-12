package org.zhyuliuk.shape.factory;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.entity.impl.EntityPoint;
import org.zhyuliuk.shape.entity.ShapeInterface;
import org.zhyuliuk.shape.shapeenum.ShapeEnum;


public class FactoryShape {
    public ShapeInterface createDefaultShape(ShapeEnum type) {
        ShapeInterface factory ;
        switch (type) {


            case BALL:
                factory = new EntityBall("defaultname", new EntityPoint(0, 0, 0), 1);
                break;
            case POINT:
                factory = new EntityPoint(0, 0, 0);
                break;

            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }

        return factory;
    }
    public EntityBall createShape(String name,EntityPoint point,double radius){
        return new EntityBall(name,point,radius);
    }
    public  EntityPoint createShape(double x,double y,double z){
        return new EntityPoint(x,y,z);
    }
}