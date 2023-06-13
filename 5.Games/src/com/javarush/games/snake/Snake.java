package com.javarush.games.snake;

import com.javarush.engine.cell.*;


import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\u26BD";
    private static final String BODY_SIGN = "\u26BE";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void setDirection(Direction direction){
        if ( (this.direction==Direction.RIGHT || this.direction==Direction.LEFT) && (snakeParts.get(0).y==snakeParts.get(1).y) && ((direction==Direction.DOWN) || (direction==Direction.UP)) ) {
            this.direction = direction;
        }

        if ( (this.direction==Direction.DOWN || this.direction==Direction.UP) && (snakeParts.get(0).x==snakeParts.get(1).x) && (direction==Direction.RIGHT || direction==Direction.LEFT) ) {
            this.direction = direction;
        }
    }

    public void move(Apple apple) {
        GameObject gameObject = createNewHead();
        if (checkCollision(gameObject)) {
            isAlive = false;
            return;
        }

        if (gameObject.x >= SnakeGame.WIDTH || gameObject.y >= SnakeGame.HEIGHT || gameObject.y < 0 || gameObject.x < 0) {
            isAlive = false;
        } else if (gameObject.x == apple.x && gameObject.y == apple.y) {
            apple.isAlive = false;
            snakeParts.add(0, gameObject);
        } else {
            snakeParts.add(0, gameObject);
            removeTail();

        }
    }

    public GameObject createNewHead() {
        if (direction == Direction.LEFT) {
            return new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
        } else if (direction == Direction.DOWN) {
            return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
        } else if (direction == Direction.UP) {
            return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
        } else if (direction == Direction.RIGHT) {
            return new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
        }
        return null;
    }


    public boolean checkCollision(GameObject gameObject) {
        int x = gameObject.x;
        int y = gameObject.y;
        int count = 0;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (x == snakeParts.get(i).x && y == snakeParts.get(i).y) {
                count++;
            }
        }
        if (count > 0) {
            return true;
        }
        return false;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void draw(Game game) {
        if (isAlive) {
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.AQUA, 75);
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.AQUA, 75);
            }
        } else {
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
            }
        }
    }

}
