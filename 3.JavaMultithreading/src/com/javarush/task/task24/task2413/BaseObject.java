package com.javarush.task.task24.task2413;

import java.util.Map;

abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    protected BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);


    abstract void move();

    public boolean intersects(BaseObject o){
        double dist = Math.sqrt(Math.pow(this.x - o.x, 2) + Math.pow(this.y - o.y, 2));
        if (dist <= Math.max(o.radius, this.radius)){
            return true;
        }else{
            return false;
        }


    }
}
