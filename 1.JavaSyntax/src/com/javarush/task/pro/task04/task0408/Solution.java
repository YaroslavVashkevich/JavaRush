package com.javarush.task.pro.task04.task0408;

import java.util.Scanner;

/* 
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (i == 0 && number % 2 == 0) {
                max = number;
                i++;
            } else if (number % 2 == 0 && number > max) {
                max = number;
            }
        }
        System.out.println(max);
    }
}