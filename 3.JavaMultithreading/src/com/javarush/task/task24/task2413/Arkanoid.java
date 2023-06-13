package com.javarush.task.task24.task2413;

import java.util.ArrayList;
import java.util.List;

public class Arkanoid {
    private int width;
    private int height;

    private Ball ball;
    private  Stand stand;
    private List<Brick> bricks;

    public static Arkanoid game;
    private boolean isGameOver = false;

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void run(){

    }


    public void move() {
        ball.move();
        stand.move();
    }

    void draw(Canvas canvas) {
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
        ball.draw(canvas);
        stand.draw(canvas);

    }
    public void checkBricksBump() {
//        for (int i = 0; i < bricks.size() ; i++) {
//            if (ball.intersects(bricks.get(i))) {
//                double angle = Math.random() * 360;
//                ball.setDirection(angle);
//                bricks.remove(i);
//            }
//        }
        for (Brick brick : new ArrayList<Brick>(bricks)) {
            if (ball.intersects(brick)) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(brick);

            }
        }
    }
    public void checkStandBump() {
        if (ball.intersects(stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }
    public void checkEndGame() {
        if (ball.y > height)
            isGameOver = true;
    }

    public static void main(String[] args) {

    }
}
