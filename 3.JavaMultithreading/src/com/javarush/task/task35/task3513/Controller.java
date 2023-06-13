package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles(){
        return model.getGameTiles();
    }

    public int getScore(){
        return this.model.score;
    }

    public void resetGame(){
        this.model.resetGameTiles();
        this.model.maxTile = 2;
        this.model.score = 0;
        this.view.isGameLost = false;
        this.view.isGameWon = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if(!this.model.canMove()) this.view.isGameLost = true;
        if(!this.view.isGameLost && !view.isGameWon){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT : model.left(); break;
                case KeyEvent.VK_RIGHT: model.right(); break;
                case KeyEvent.VK_UP: model.up(); break;
                case KeyEvent.VK_DOWN: model.down(); break;
                case KeyEvent.VK_Z: model.rollback(); break;
                case KeyEvent.VK_R: model.randomMove(); break;
                case KeyEvent.VK_A: model.autoMove(); break;
            }
        }
        if(this.model.maxTile == WINNING_TILE) this.view.isGameWon = true;
        view.repaint();
    }
}
