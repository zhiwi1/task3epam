package org.zhyuliuk.shape.parser;

import org.zhyuliuk.shape.parser.impl.BallParameter;

import java.util.HashMap;
import java.util.List;

public interface EntityBallParser {

        public HashMap<String, BallParameter> parse(List<String> list);

}
