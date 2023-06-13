package com.javarush.task.pro.task05.task0506;

import java.util.Arrays;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        array = new int[N];
        int i = 0;

        while (i < N){
            int number = scanner.nextInt();
            array[i] = number;
            i++;
        }
        int min = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min){
                min = array[j];
            }
        }

        System.out.println(min);
    }
}
