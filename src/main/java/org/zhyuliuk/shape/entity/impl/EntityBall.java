package org.zhyuliuk.shape.entity.impl;

import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.observer.BallEvent;
import org.zhyuliuk.shape.observer.Observable;
import org.zhyuliuk.shape.observer.Observer;
import org.zhyuliuk.shape.observer.impl.BallObserver;

import java.util.ArrayList;
import java.util.List;

public class EntityBall  implements Observable {
    private String name;
    private Point pointCenter;
    private double radius;
    private List<BallObserver> observers = new ArrayList<>();

    public EntityBall(String name, Point pointCenter, double radius) {
        this.name = name;
        this.pointCenter = pointCenter;
        this.radius = radius;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public Point getPointCenter() {
        return pointCenter;
    }

    public void setPointCenter(Point pointCenter) {
        this.pointCenter = pointCenter;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius)  throws ShapesException{
        if ( radius < 0) {
            throw new ShapesException("Exception: radius can't be < 0 radius="+radius);
        }
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityBall entityBall = (EntityBall) o;
        return radius == entityBall.radius && name.equals(entityBall.name) && pointCenter.equals(entityBall.pointCenter);
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < name.length(); i++) {
            result = 31 * result + name.charAt(i);
        }
        result = 31 * result + pointCenter.hashCode();
        result = 31 * result + (int) radius;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("EntityBall{name='").append(name).
                append('\'').append( ", PointCenter=").append(pointCenter).append(", radius=").append(radius).append( '}');
        return stringBuilder.toString();
    }

    @Override
    public void attach(BallObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(BallObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (observers == null){
            return;
        }
        for (BallObserver observer : observers) {
        BallEvent event = new BallEvent(this);
        observer.parameterChanged(event);}
    }

}
