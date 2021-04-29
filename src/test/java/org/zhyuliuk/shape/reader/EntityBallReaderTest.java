package org.zhyuliuk.shape.reader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.reader.impl.EntityBallReaderImpl;

import java.util.ArrayList;
import java.util.List;

public class EntityBallReaderTest {
    private final static EntityBallReaderImpl ballReader = EntityBallReaderImpl.getInstance();
    private final static String PATH_NAME = "src/test/resources/testRead.txt";

    @Test(description = "Test of reading")
    public void ReadInEntityBallTest() throws ShapesException {
        List<String> list = ballReader.readEntityBall(PATH_NAME);
        List<String> expected = new ArrayList<>();
        expected.add("name,1,2,3,4");
        expected.add("ff");
        expected.add("1");
        Assert.assertEquals(list, expected);
    }
    @Test(description = "Test of reading")
    public void ReadCorrectlyInEntityBallTest() throws ShapesException {
        List<String> list = ballReader.readCorrectlyEntityBall(PATH_NAME);
        List<String> expected = new ArrayList<>();
        expected.add("name,1,2,3,4");
        Assert.assertEquals(list, expected);
    }

}