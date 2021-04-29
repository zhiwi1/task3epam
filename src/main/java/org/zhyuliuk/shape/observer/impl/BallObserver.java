package org.zhyuliuk.shape.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.observer.BallEvent;
import org.zhyuliuk.shape.observer.Observer;
import org.zhyuliuk.shape.warehouse.WareHouse;

public class BallObserver implements Observer {
    private final static Logger logger= LogManager.getLogger();
    @Override
    public void parameterChanged(BallEvent event) {
        var service= CalculatingEntityBallActionImpl.getInstance();
        double area = 0;
        double volume = 0;
        EntityBall source=event.getSource();
        try {
            area = service.calculateSurfaceArea(source);
            volume = service.calculateVolumeBall(source);
        } catch (ShapesException exception) {
            logger.info("exception in calculating");
        }
        String name = source.getName();
        WareHouse warehouse = WareHouse.getInstance();
        try{
            warehouse.updateParameters(name, area, volume);
        }catch (ShapesException e){
            logger.log(Level.WARN, e.getMessage());
        }
    }
}
