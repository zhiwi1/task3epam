package org.zhyuliuk.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.parser.impl.BallParameter;
import org.zhyuliuk.shape.parser.impl.EntityBallParserImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityBallParserTest {
    private final static EntityBallParserImpl parser = EntityBallParserImpl.getInstance();
    private final static Logger logger = LogManager.getLogger();

    @Test(description = "Test of reading")
    public void parseTest() throws ShapesException {
        List<String> list = new ArrayList<>();
        HashMap<String, BallParameter> expectedMap = new HashMap<>();
        expectedMap.put("name", new BallParameter(1, 2, 3, 4));
        String ballLine = "name,1,2,3,4";
        list.add(ballLine);
        HashMap<String, BallParameter> actualMap = parser.parse(list);
        Assert.assertEquals(actualMap, expectedMap);
    }
}
