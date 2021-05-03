package org.zhyuliuk.shape.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zhyuliuk.shape.parser.EntityBallParser;
import org.zhyuliuk.shape.reader.EntityBallReader;
import org.zhyuliuk.shape.validator.DataValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class EntityBallReaderImpl implements EntityBallReader {
    private final static Logger logger = LogManager.getLogger();
    private static EntityBallReaderImpl instance;

    private EntityBallReaderImpl() {
    }

    public static EntityBallReaderImpl getInstance() {
        if (instance == null) {
            instance = new EntityBallReaderImpl();
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
            list = br.lines().filter(DataValidator::isLineValid).collect(Collectors.toList());
        } catch (IOException e) {
            logger.info("Error in reading");
        }
        return list;
    }
}

