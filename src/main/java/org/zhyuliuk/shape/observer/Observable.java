package org.zhyuliuk.shape.observer;

import org.zhyuliuk.shape.observer.impl.BallObserver;

public interface Observable {


        void attach(BallObserver observer);

        void detach(BallObserver observer);

        void notifyObservers();


}
