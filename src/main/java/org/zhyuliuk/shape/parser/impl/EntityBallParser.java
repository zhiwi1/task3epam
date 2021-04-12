package org.zhyuliuk.shape.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.entity.impl.EntityPoint;
import org.zhyuliuk.shape.factory.FactoryShape;
import org.zhyuliuk.shape.parser.EntityBallParserInterface;

import java.util.ArrayList;
import java.util.List;


public class EntityBallParser implements EntityBallParserInterface {
    private static final Logger logger = LogManager.getLogger(EntityBallParser.class);
    private static final String REGEX = ",";
    private static final FactoryShape BALL_FACTORY = new FactoryShape();
    private static EntityBallParser instance ;

    private EntityBallParser() {
    }

    public static EntityBallParser getInstance() {
        if (instance == null) {
            instance = new EntityBallParser();
        }
        return instance;
    }


    public List<EntityBall> parse(List<String> list) {
        List<EntityBall> result = new ArrayList<>();
        for (String str : list) {
            String[] arguments = str.split(REGEX);
            for(int i=0;i<arguments.length;i++){logger.info(arguments[i]);}


                result.add(new EntityBall(arguments[0].trim(),
                        new EntityPoint(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]), Double.parseDouble(arguments[3])),
                        Double.parseDouble(arguments[4])));

        }
        return result;
    }
}


