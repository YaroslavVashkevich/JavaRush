package com.javarush.task.pro.task03.task0306;

import java.util.Scanner;

/* 
Треугольник
*/

public class Solution {
    private static final String TRIANGLE_EXISTS = "треугольник существует";
    private static final String TRIANGLE_NOT_EXISTS = "треугольник не существует";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        if (number1 < (number2 + number3) && number2 < (number3 + number1) && number3 < (number1 + number2)){
            System.out.println(TRIANGLE_EXISTS);
        }else if (number1 >= (number2 + number3) || number2 >= (number3 + number1) || number3 >= (number1 + number2)){
            System.out.println(TRIANGLE_NOT_EXISTS);
        }
    }
}
