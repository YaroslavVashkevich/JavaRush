package com.javarush.task.task20.task2015.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Black", 3, 0));
        horses.add(new Horse("White", 3, 0));
        horses.add(new Horse("Red", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }
    public Horse getWinner(){
        Collections.sort(horses, Comparator.comparing(h -> h.getDistance()));
        return horses.get(horses.size() - 1);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
