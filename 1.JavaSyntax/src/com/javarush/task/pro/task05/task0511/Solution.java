package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        multiArray = new int[number1][];
        int a = 0;
        while (a < number1){
            int number2 = sc.nextInt();
            multiArray[a] = new int[number2];
            a++;
        }
        for (int i = 0; i <multiArray.length ; i++) {
            for (int j = 0; j <multiArray[i].length ; j++) {
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
