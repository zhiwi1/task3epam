package org.zhyuliuk.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zhyuliuk.shape.exception.ShapesException;
import org.zhyuliuk.shape.reader.impl.EntityBallReader;

public class ValidatorDataTest {
    @Test
    public void isLineValidTest() throws ShapesException {
        String line = "name,1,2,3,4";
        Assert.assertTrue(ValidatorData.isLineValid(line));
    }

    @Test
    public void isFileValidTest() throws ShapesException {
        String line = "src/test/resources/testRead.txt";
        Assert.assertTrue(ValidatorData.isFileValid(line));
    }

    @Test
    public void isFileValidNullTest() {
        Assert.assertFalse(ValidatorData.isFileValid(null));
    }

    @Test
    public void isFileEmptyTest() {
        Assert.assertFalse(ValidatorData.isFileValid(""));
    }

    @Test
    public void isFileInvalidCorrectFileNameTest() {
        Assert.assertFalse(ValidatorData.isFileValid("correctfile"));
    }


}
