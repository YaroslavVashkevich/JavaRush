package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Th1 th1 = new Th1();
        Th2 th2 = new Th2();
        Th3 th3 = new Th3();
        Th4 th4 = new Th4();
        Th5 th5 = new Th5();
        threads.add(th1);
        threads.add(th2);
        threads.add(th3);
        threads.add(th4);
        threads.add(th5);
    }

    public static void main(String[] args) {
        for (Thread th : threads) {
            th.start();
        }

    }

    public static class Th1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Th2 extends Thread {
        @Override
        public void run() {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class Th3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Th4 extends Thread implements Message {
        @Override
        public void run() {
            while (!(Thread.currentThread().isInterrupted())) {

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Th5 extends Thread {
        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            int sum = 0;
            while (!str.equals("N")) {
                sum = sum + Integer.parseInt(str);
                str = sc.nextLine();
            }
            System.out.println(sum);
        }
    }

}