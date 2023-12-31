package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double speed;
    private double direction;
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }


    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    @Override
    void draw(Canvas canvas) {
        
    }


    void move() {
        double dx = speed * direction;
        x = x + dx;

    }

    
    void moveLeft() {
        direction = -1;
    }


    void moveRight() {
        direction = 1;
    }
}
