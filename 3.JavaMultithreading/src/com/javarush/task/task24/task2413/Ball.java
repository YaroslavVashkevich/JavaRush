package com.javarush.task.task24.task2413;

public class Ball extends BaseObject{
    private double speed;
    private double direction;

    private double dx;
    private double dy;

    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;
        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }


    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

    }
    void start() {
        this.isFrozen = false;
    }

    void setDirection(double direction) {
        this.direction = direction;

        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }
    void checkRebound(int minx, int maxx, int miny, int maxy){
        
    }
}
