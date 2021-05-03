package org.zhyuliuk.shape.parser;

import java.util.HashMap;
import java.util.List;

public interface EntityBallParser {
    public HashMap<String, BallParameter> parseAllLines(List<String> list);
}
