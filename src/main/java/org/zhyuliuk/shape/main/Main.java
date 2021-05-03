package org.zhyuliuk.shape.main;

import org.zhyuliuk.shape.action.CalculatingEntityBallAction;
import org.zhyuliuk.shape.action.impl.CalculatingEntityBallActionImpl;
import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.factory.FactoryShape;
import org.zhyuliuk.shape.parser.EntityBallParser;
import org.zhyuliuk.shape.parser.impl.BallParameter;
import org.zhyuliuk.shape.parser.impl.EntityBallParserImpl;
import org.zhyuliuk.shape.reader.impl.EntityBallReaderImpl;
import org.zhyuliuk.shape.repository.BallRepository;
import org.zhyuliuk.shape.repository.impl.BallRepositoryImpl;
import org.zhyuliuk.shape.warehouse.BallProperties;
import org.zhyuliuk.shape.warehouse.WareHouse;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ShapesException {
        String PATH_NAME = "src/main/resources/data/input.txt";
        EntityBallReaderImpl ballReader = EntityBallReaderImpl.getInstance();
        List<String> ballListString = ballReader.readCorrectlyEntityBall(PATH_NAME);
        EntityBallParser ballParser = EntityBallParserImpl.getInstance();
        HashMap<String, BallParameter> hashMap = ballParser.parse(ballListString);
        FactoryShape factory=new FactoryShape();
        List<EntityBall> entityBallList=factory.createBalls(hashMap);
        System.out.println(entityBallList.get(0));
        BallRepository ballRepository= BallRepositoryImpl.getInstance();
        ballRepository.addBall(entityBallList.get(0));
        WareHouse wareHouse=WareHouse.getInstance();
        CalculatingEntityBallAction action=CalculatingEntityBallActionImpl.getInstance();
        wareHouse.putParameters(entityBallList.get(0).getName(),action.calculateSurfaceArea(entityBallList.get(0)),action.calculateVolumeBall(entityBallList.get(0)));

    }
}

