package com.epam.jwd.model.figure;

import com.epam.jwd.model.Point;

public interface Figure {
    void setPoints(Point[] points);
    boolean pointsMatch();
    String getType();
    boolean isPossibleToBuild();
}
