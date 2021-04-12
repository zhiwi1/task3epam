package org.zhyuliuk.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.entity.impl.EntityPoint;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.parser.impl.EntityBallParser;

import java.util.ArrayList;
import java.util.List;

public class EntityBallParserTest {
    private final static EntityBallParser parser = EntityBallParser.getInstance();
private final static Logger logger= LogManager.getLogger();
    @Test(description = "Test of reading")
    public void parseTest() throws ShapesException {
        List<String> list = new ArrayList<String>();
        String ballLine = "name,1,2,3,4";
        list.add(ballLine);
        List<EntityBall> actualList = parser.parse(list);

        List<EntityBall> expectedList = new ArrayList<>();
        expectedList.add(new EntityBall("name", new EntityPoint(1, 2, 3), 4));
        Assert.assertEquals(actualList.get(0), expectedList.get(0));
    }
}
