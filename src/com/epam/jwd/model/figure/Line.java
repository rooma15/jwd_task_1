package com.epam.jwd.model.figure;

import com.epam.jwd.model.Point;

public class Line implements Figure {
    private Point[] points;

    public Line(){
        points = new Point[2];
        points[0] = new Point();
        points[1] = new Point();
    }

    public Line(Point[] points){
         this.points = new Point[2];
        this.points = points;
    }

    public Line(Point point1, Point point2){
        points  = new Point[2];
        points[0] = point1;
        points[1] = point2;
    }

    @Override
    public boolean isPossibleToBuild() {
        return !pointsMatch();
    }

    @Override
    public void setPoints(Point[] points) {
        this.points = points;
    }

    public void setPoints(Point point1, Point point2){
        this.points[0] = point1;
        this.points[1] = point2;
    }

    @Override
    public boolean pointsMatch() {
        return points[0].equals(points[1]);
    }

    @Override
    public String getType() {
        return "Line";
    }

    @Override
    public String toString() {
        return String.format("{{%1$d, %2$d}, {%3$d, %4$d}}", points[0].getX(), points[0].getY(), points[1].getX(), points[1].getY());
    }
}
