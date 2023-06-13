package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private final static int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score = 0;
    //protected int maxTile = 2;
    protected int maxTile = 0;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty())
                    list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    private void addTile() {
        if (!getEmptyTiles().isEmpty()) {
            int index = (int) (getEmptyTiles().size() * Math.random());
            getEmptyTiles().get(index).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    protected void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean mergeTiles(Tile[] tiles) {
        compressTiles(tiles);
        boolean chane = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {
                chane = true;
                tiles[i].value *= 2;
                tiles[i + 1] = new Tile();
                maxTile = Math.max(maxTile, tiles[i].value);
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return chane;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    change = true;
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                }
            }
        }
        return change;
    }

    public void rotateMatrix() {
        Tile tmp;
        int temp = FIELD_WIDTH - 1;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < temp - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[temp - j][i];
                gameTiles[temp - j][i] = gameTiles[temp - i][temp - j];
                gameTiles[temp - i][temp - j] = gameTiles[j][temp - i];
                gameTiles[j][temp - i] = tmp;
            }
        }
    }

    public void left() {
        if(isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateMatrix();
        rotateMatrix();
        left();
        rotateMatrix();
        rotateMatrix();
    }

    public void up() {
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
        left();
        rotateMatrix();
    }

    public void down() {
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateMatrix();
        left();
        rotateMatrix();
        rotateMatrix();
        rotateMatrix();
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[j][i].value == gameTiles[j + 1][i].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tile = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                tile[i][j] = new Tile();
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tile[i][j].value = tiles[i][j].value;
            }
        }
        previousStates.push(tile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty())
            gameTiles = previousStates.pop();
        if (!previousScores.isEmpty())
            score = previousScores.pop();
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0: left();break;
            case 1: up(); break;
            case 2: right(); break;
            case 3: down(); break;
        }
    }

    public boolean hasBoardChanged(){
        int valueGameTiles = 0;
        int valuePreviousStates = 0;
        if(!previousStates.isEmpty()){
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles[i].length; j++) {
                    valueGameTiles += gameTiles[i][j].value;
                    valuePreviousStates += previousStates.peek()[i][j].value;
                }
            }
        }
        return valueGameTiles != valuePreviousStates;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency efficiency ;
        move.move();
        if(hasBoardChanged()){
            efficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        else
            efficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return efficiency;
    }

    public void autoMove(){
        final PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(
                4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        MoveEfficiency mov = queue.peek();
        mov.getMove().move();
    }
}