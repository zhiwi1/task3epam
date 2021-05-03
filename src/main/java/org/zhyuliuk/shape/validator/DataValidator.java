package org.zhyuliuk.shape.validator;

import org.zhyuliuk.shape.entity.EntityBall;
import org.zhyuliuk.shape.entity.Point;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private final static String BALL_REGEXP = "^\\s*\\w+((\\s*,\\d+)|(\\s*,\\d+d)|(\\s*,\\d+\\.\\d+)|(\\s*,\\d+\\.\\d+d)){4}$";

    public static boolean isBallValid(Point point, double radius) {
        return radius <= 0 && point != null;
    }
    public static boolean isBallValid(EntityBall entityBall) {
        return entityBall.getRadius() <= 0 && entityBall.getPointCenter() != null&&entityBall.getName()!=null;
    }
    public static boolean isLineValid(String lineBall) {
        return lineBall.matches(BALL_REGEXP);
    }

    public static boolean isFileValid(String fileName) {
        return fileName != null && Files.exists(Paths.get(fileName)) && (new File(fileName)).length() > 0L && fileName.length() != 0;
    }


}
