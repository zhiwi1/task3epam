package org.zhyuliuk.shape.reader;

import java.util.List;

public interface EntityBallReader {
    public List readEntityBall(String relativePath);

    public List<String> readCorrectlyEntityBall(String relativePath);
}
