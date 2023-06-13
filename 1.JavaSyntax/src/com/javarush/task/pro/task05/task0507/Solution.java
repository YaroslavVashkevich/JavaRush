package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        array = new int[number1];
        int i = 0;

        while (i < number1){
            int number2 = scanner.nextInt();
            array[i] = number2;
            i++;
        }
        int max = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max){
                max = array[j];
            }
        }

        System.out.println(max);
    }
}
