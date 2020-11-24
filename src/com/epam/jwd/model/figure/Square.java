package com.epam.jwd.model.figure;

import com.epam.jwd.model.Point;

public class Square implements Figure{

    private Point[] points;

    public Square(){
        points = new Point[4];
        points[0] = new Point();
        points[1] = new Point();
        points[2] = new Point();
        points[3] = new Point();
    }

    public Square(Point[] points){
        this.points = new Point[4];
        this.points = points;
    }

    public Square(Point point1, Point point2, Point point3, Point point4){
        points = new Point[4];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        points[3] = point4;
    }

    @Override
    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public boolean pointsMatch() {
        int i = 0;
        int j;
        while(i < 3){
            j = i + 1;
            while(j < 4){
                if(points[i].equals(points[j])){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean isPossibleToBuild(){
        double side1 = Math.hypot(Math.abs(points[0].getX() - points[1].getX()), Math.abs(points[0].getY() - points[1].getY()));
        double side2 = Math.hypot(Math.abs(points[1].getX() - points[2].getX()), Math.abs(points[1].getY() - points[2].getY()));
        double side3 = Math.hypot(Math.abs(points[2].getX() - points[3].getX()), Math.abs(points[2].getY() - points[3].getY()));
        double side4 = Math.hypot(Math.abs(points[3].getX() - points[0].getX()), Math.abs(points[3].getY() - points[0].getY()));
        return (side1 == side2 && side2 == side3 && side3 == side4);
    }

    @Override
    public String getType() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("{{%1$d, %2$d}, {%3$d, %4$d}, {%5$d, %6$d}, {%7$d, %8$d}}",
                points[0].getX(),
                points[0].getY(),
                points[1].getX(),
                points[1].getY(),
                points[2].getX(),
                points[2].getY(),
                points[3].getX(),
                points[3].getY());
    }
}
