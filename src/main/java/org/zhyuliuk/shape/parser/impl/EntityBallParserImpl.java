package org.zhyuliuk.shape.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.parser.BallParameter;
import org.zhyuliuk.shape.parser.EntityBallParser;

import java.util.HashMap;
import java.util.List;


public class EntityBallParserImpl implements EntityBallParser {
    private static final Logger logger = LogManager.getLogger(EntityBallParserImpl.class);
    private static final String REGEXP_DELIMITER = ",";
    private static EntityBallParserImpl instance;

    private EntityBallParserImpl() {
    }

    public static EntityBallParserImpl getInstance() {
        if (instance == null) {
            instance = new EntityBallParserImpl();
        }
        return instance;
    }

    public HashMap<String, BallParameter> parseAllLines(List<String> list) {
        HashMap<String, BallParameter> map = new HashMap<>();
        for (String str : list) {
            String[] arguments = str.split(REGEXP_DELIMITER);
            for (String argument : arguments) {
                logger.info(argument);
                try {
                    BallParameter parameter = new BallParameter();
                    parameter.setX(Double.parseDouble(arguments[1]));
                    parameter.setY(Double.parseDouble(arguments[2]));
                    parameter.setZ(Double.parseDouble(arguments[3]));
                    parameter.setRadius(Double.parseDouble(arguments[4]));
                    map.put(arguments[0].trim(), parameter);
                } catch (NumberFormatException exception) {
                    logger.error(argument + ":not valid ball");
                }
            }
        }
        return map;
    }
}


