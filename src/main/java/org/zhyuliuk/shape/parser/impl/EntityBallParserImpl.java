package org.zhyuliuk.shape.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.parser.EntityBallParser;

import java.util.HashMap;
import java.util.List;


public class EntityBallParserImpl implements EntityBallParser {
    private static final Logger logger = LogManager.getLogger(EntityBallParserImpl.class);
    private static final String REGEXP_DELIMITER = ",";
//    private static final FactoryShape BALL_FACTORY = new FactoryShape();
    private static EntityBallParserImpl instance ;

    private EntityBallParserImpl() {
    }

    public static EntityBallParserImpl getInstance() {
        if (instance == null) {
            instance = new EntityBallParserImpl();
        }
        return instance;
    }
    public HashMap<String,BallParameter> parse(List<String> list) {
        HashMap<String,BallParameter> map=new HashMap<>();
        for (String str : list) {
            String[] arguments = str.split(REGEXP_DELIMITER);
            for (int i = 0; i < arguments.length; i++) {
                logger.info(arguments[i]);
                BallParameter parameter = new BallParameter();
                parameter.setX(Double.parseDouble(arguments[1]));
                parameter.setY(Double.parseDouble(arguments[2]));
                parameter.setZ(Double.parseDouble(arguments[3]));
                parameter.setRadius(Double.parseDouble(arguments[4]));
                map.put(arguments[0].trim(), parameter);
            }
        }
        return map;
    }
}


