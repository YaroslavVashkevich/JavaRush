package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    markX(a, i, j);
                    markY(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void markX(byte[][] a, int x, int y) {
        for (int i = x; i < a.length; i++) {
            if (a[i][y] == 1) {
                markY(a, i, y);
            } else {
                break;
            }
        }
    }

    public static void markY(byte[][] a, int x, int y) {
        for (int i = y; i < a[x].length; i++) {
            if (a[x][i] == 1) {
                a[x][i] = 0;
            } else {
                break;
            }
        }
    }


}
