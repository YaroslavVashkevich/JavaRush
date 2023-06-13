package com.javarush.task.pro.task08.task0803;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/* 
Минимальный элемент массива
*/

public class Solution {

    public static void main(String[] args) {
        int[] intArray = getArrayOfTenElements();
        System.out.println(min(intArray));
    }

    public static int min(int[] ints) {
        //напишите тут ваш код
        int min = ints[0];
        for (int i = 0; i < ints.length; i++) {
//            if (ints[i] < min){
//                min = ints[i];
//            }
            min = Math.min(min, ints[i]);
        }
        return min;
    }

    public static int[] getArrayOfTenElements() {
        //напишите тут ваш код
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < array.length){
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }
}
