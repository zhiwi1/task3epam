package org.zhyuliuk.shape.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.validator.ValidatorData;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class EntityBallReader {
    private final static Logger logger = LogManager.getLogger();
    private static EntityBallReader instance;

    private EntityBallReader() {
    }

    public static EntityBallReader getInstance() {
        if (instance == null) {
            instance = new EntityBallReader();
        }
        return instance;
    }

    public List<String> readEntityBall(String relativePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(relativePath))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.info("Error in reading");
        }
        return list;
    }
    public List<String> readCorrectlyEntityBall(String relativePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(relativePath))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.info("Error in reading");
        }
        List<String> correctList=new ArrayList<>();
        for(String line:list){
            if(ValidatorData.isLineValid(line)) {
                correctList.add(line);
            }
            }

        return correctList;
    }
}

