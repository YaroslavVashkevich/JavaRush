package com.javarush.task.pro.task03.task0308;

import java.util.Scanner;

/* 
Координатные четверти
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int numberX = sc.nextInt();
        int numberY = sc.nextInt();

        if (numberX > 0 && numberY > 0) {
            System.out.println("1");
        } else if (numberX < 0 && numberY > 0) {
            System.out.println("2");
        } else if (numberX < 0 && numberY < 0) {
            System.out.println("3");
        } else if (numberX > 0 && numberY < 0) {
            System.out.println("4");
        }

    }
}
