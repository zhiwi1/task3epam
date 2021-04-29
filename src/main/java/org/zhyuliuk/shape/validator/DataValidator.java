package org.zhyuliuk.shape.validator;

import org.zhyuliuk.shape.entity.impl.Point;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private final static String BALL_REGEX = "^\\s*\\w+((\\s*,\\d+)|(\\s*,\\d+d)|(\\s*,\\d+\\.\\d+)|(\\s*,\\d+\\.\\d+d)){4}$";



    public static boolean isBallValid(Point point, double radius) {
        return radius <= 0 && point != null;
    }
    public static boolean isLineValid(String lineBall){
        Pattern pattern = Pattern.compile(BALL_REGEX);
        Matcher matcher = pattern.matcher(lineBall);
        return matcher.find();
    }

    public static boolean isFileValid(String fileName) {
        return fileName != null && Files.exists(Paths.get(fileName)) && (new File(fileName)).length() > 0L && fileName.length() != 0;
    }


}
