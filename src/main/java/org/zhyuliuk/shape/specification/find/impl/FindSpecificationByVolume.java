package org.zhyuliuk.shape.specification.find.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallAction;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.specification.find.FindSpecificationInterface;

public class FindSpecificationByVolume implements FindSpecificationInterface {
    private final static Logger logger = LogManager.getLogger();
    private double minDesiredVolume;
    private double maxDesiredVolume;

    public FindSpecificationByVolume(int desiredVolumeMin, int desiredVolumeMax) {
        super();
        this.minDesiredVolume = desiredVolumeMin;
        this.maxDesiredVolume = desiredVolumeMax;
    }

    @Override
    public boolean specified(EntityBall entityBall) {
        double volume = 0;
        try {
            CalculatingEntityBallAction calculatingEntityBallAction = CalculatingEntityBallAction.getInstance();
            volume = calculatingEntityBallAction.calculateVolumeBall(entityBall);
        } catch (ShapesException exception) {
            logger.log(Level.INFO, "exception in calculating volume in " + entityBall);
        }

        return (volume >= minDesiredVolume) && (volume <= maxDesiredVolume);
    }
}
