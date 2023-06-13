package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            int i = numSeconds;
            while (numSeconds >= 0 ) {
                if (numSeconds > 0) {
                    System.out.print(numSeconds + " ");
                } else {
                    System.out.println("Марш!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    if (i == 4) {
                        System.out.println("Прервано!");
                        break;
                    }
                }
                numSeconds--;
                }

        }
    }
}