package org.zhyuliuk.shape.validator;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidatorDataTest {
    @Test
    public void isLineValidTest() {
        String line = "name,1,2,3,4";
        Assert.assertTrue(DataValidator.isLineValid(line));
    }

    @Test
    public void isFileValidTest() {
        String line = "src/test/resources/testRead.txt";
        Assert.assertTrue(DataValidator.isFileValid(line));
    }

    @Test
    public void isFileValidNullTest() {
        Assert.assertFalse(DataValidator.isFileValid(null));
    }

    @Test
    public void isFileEmptyTest() {
        Assert.assertFalse(DataValidator.isFileValid(""));
    }

    @Test
    public void isFileInvalidCorrectFileNameTest() {
        Assert.assertFalse(DataValidator.isFileValid("correctfile"));
    }


}
