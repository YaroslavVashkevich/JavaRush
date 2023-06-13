package com.javarush.task.pro.task02.task0215;

import java.util.Scanner;

/* 
Чтение чисел
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int value1 = sc.nextInt();
        int value2 = sc.nextInt();
        int value3 = sc.nextInt();
        System.out.println((value1 + value2 + value3) / 3);

    }
}
