package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            int max = 0;
            while (fileInputStream.available() > 0) {
                int bytes = fileInputStream.read();
                if (bytes > max) {
                    max = bytes;
                }

            }
            System.out.println(max);
        }
    }
}
