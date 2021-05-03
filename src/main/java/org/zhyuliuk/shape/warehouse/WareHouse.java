package org.zhyuliuk.shape.warehouse;

import org.zhyuliuk.shape.exception.ShapesException;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

    private static final WareHouse instance = new WareHouse();
    private final Map<String, BallProperties> ellipseMap = new HashMap<>();

    private WareHouse() {
    }

    public static WareHouse getInstance() {
        return instance;
    }

    public void putParameters(String name, double volume, double area) {
        BallProperties data = new BallProperties(volume, area);
        data.setArea(area);
        data.setVolume(volume);
        instance.ellipseMap.put(name, data);
    }

    public BallProperties getParameters(String name) throws ShapesException {
       BallProperties data = instance.ellipseMap.get(name);
        if (data == null) {
            throw new ShapesException("no elements in warehouse");
        }
        return new BallProperties(data);
    }

    public void updateParameters(String name, double volume, double area) throws ShapesException {
        BallProperties data = ellipseMap.get(name);
        if (data == null) {
            throw new ShapesException("No  elements in warehouse");
        }
        data.setArea(area);
        data.setVolume(volume);

    }
}
