package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;

    public Tile() {
        this.value = 0;
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isEmpty(){
        return value == 0;
    }

    public Color getFontColor(){
        return this.value < 16 ? new Color(0x776e65) : new Color(0xf9f6f2);
    }

    public Color getTileColor(){
        Color color = null;
        switch (this.value){
            case 0: return color = new Color(0xcdc1b4);
            case 2: return color = new Color(0xeee4da);
            case 4: return color = new Color(0xede0c8);
            case 8: return color = new Color(0xf2b179);
            case 16: return color = new Color(0xf59563);
            case 32: return color = new Color(0xf67c5f);
            case 64: return color = new Color(0xf65e3b);
            case 128: return color = new Color(0xedcf72);
            case 256: return color = new Color(0xedcc61);
            case 512: return color = new Color(0xedc850);
            case 1024: return color = new Color(0xedc53f);
            case 2048: return color = new Color(0xedc22e);
            default:
                color = new Color(0xff0000);
        }
        return color;
    }
}
