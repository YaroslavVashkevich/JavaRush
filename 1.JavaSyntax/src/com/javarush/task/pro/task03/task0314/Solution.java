package com.javarush.task.pro.task03.task0314;

import java.util.Scanner;

/* 
Сломанная клавиатура
*/

public class Solution {
    public static String secret = "AmIGo";

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println((secret.equalsIgnoreCase(str)) ? "доступ разрешен": "доступ запрещен");
    }
}
