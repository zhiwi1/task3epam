package org.zhyuliuk.shape.observer;

import org.zhyuliuk.shape.entity.EntityBall;

import java.util.EventObject;

public class BallEvent extends EventObject {
    public BallEvent(Object source) {
        super(source);
    }

    @Override
    public EntityBall getSource() {
        return (EntityBall) super.getSource();
    }
}
