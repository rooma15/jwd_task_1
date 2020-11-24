package com.epam.jwd.app;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.figure.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger();
        Point[] points = new Point[4];
        points[0] = new Point(1, 2);
        points[1] = new Point(1, 2);
        points[2] = new Point(5, 6);
        points[3] = new Point(7, 8);


        Figure[] list = new Figure[5];
        list[0] = new Line(points[0], points[1]);
        list[1] = new Line(points[1], points[2]);
        list[2] = new Triangle(points[0], points[1], points[2]);
        list[3] = new Triangle(points[1], points[2], points[3]);
        list[4] = new Square(points);


        printPoints(logger, points);
        logFigures(logger, list);
    }



    private static void logFigures(Logger logger, Figure[] list) {
        for(Figure figure : list){
            if(figure.pointsMatch()){
                logger.error("object " + figure + " is not a figure " + figure.getType());
            }else{
                if(!figure.isPossibleToBuild()){
                    if(figure instanceof Triangle){
                        logger.error("Triangle " + figure + " can not exist");
                    }else if(figure instanceof Square){
                        logger.error("object " + figure + " is not a square");
                    }
                }
                else{
                    logger.info(figure.getType() + figure);
                }
            }
        }
    }

    private static void printPoints(Logger logger, Point[] points) {
        int i = 0;
        do {
            logger.info("Point " + points[i]);
            i++;
        }while(i < points.length);
    }
}
