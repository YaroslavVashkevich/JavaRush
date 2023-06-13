package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.HashSet;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score +=5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (snake.isAlive == false) {
            gameOver();
        }
        if (snake.getLength() > GOAL) {
            win();
        }
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            snake.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }
        if (key == Key.SPACE && isGameStopped == true){
            createGame();
        }
    }

    private void createGame() {
        score = 0;
        setScore(score);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
            createNewApple();
            isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER!!!", Color.RED, 65);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "YOU WIN!!!", Color.YELLOW, 65);
    }

    private void createNewApple() {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            while (snake.checkCollision(apple)){
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }

    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

}