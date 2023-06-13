package com.javarush.task.pro.task05.task0505;

import java.util.Arrays;
import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int[] array = new int[number1];
        if (number1 > 0) {
            array = new int[number1];
            int i = 0;
            while (i < number1) {
                int number2 = scanner.nextInt();
                array[i] = number2;
                i++;
            }
        }
        if (number1 % 2 == 0) {
            for (int i = array.length - 1; i >= 0 ; i--) {
                System.out.println(array[i]);
            }
        } else if (number1 % 2 != 0){
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
