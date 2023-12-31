package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String str = "";
        if (a > b){
            for (int i = a; i >= b; i--) {
               str = str + i + " ";
            }
        } else if (a < b){
            for (int i = a; i <= b; i++) {
                str = str + i + " ";
            }
        }
        return str.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}