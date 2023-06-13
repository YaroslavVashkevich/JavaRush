package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        strings = new String[6];
        int j = 0;
        while (j < strings.length) {
            strings[j] = scanner.nextLine();
            j++;
        }

        boolean count = false;
        for (int i = 0; i < strings.length; i++) {
            String test = strings[i];
            if (strings[i] != null) {
                for (int k = i + 1; k < strings.length; k++) {
                    if (test.equals(strings[k])) {
                        strings[k] = null;
                        count = true;
                    }
                }
            }
            if (count) {
                strings[i] = null;
                count = false;
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
