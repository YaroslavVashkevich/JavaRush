package com.javarush.task.pro.task04.task0418;

import java.util.Scanner;

/* 
Стакан наполовину пуст или наполовину полон?
*/

public class Solution {
    public static void main(String[] args) {
        double glass = 0.5;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        boolean isGlass = scanner.nextBoolean();
        System.out.println(isGlass ? (int)Math.ceil(glass) : (int)Math.floor(glass));
    }
}