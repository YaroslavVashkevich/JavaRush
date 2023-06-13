package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals("exit")){
            if (isNumeric(str) && str.contains(".")){
                print(Double.parseDouble(str));
            } else if (isNumeric(str) && (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 128 )) {
                print((short) Integer.parseInt(str));
            } else if (isNumeric(str) && (Integer.parseInt(str) <= 0 || Integer.parseInt(str) >= 128)) {
                print(Integer.parseInt(str));
            }else{
                print(str);
            }
            str = sc.nextLine();
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
