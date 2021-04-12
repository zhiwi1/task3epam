package org.zhyuliuk.shape.parser;

import org.zhyuliuk.shape.entity.impl.EntityBall;
import org.zhyuliuk.shape.exception.ShapesException;

import java.util.List;

public interface EntityBallParserInterface {

        List<EntityBall> parse(List<String> list) throws ShapesException;

}
