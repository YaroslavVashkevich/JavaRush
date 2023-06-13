package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            int min = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int bytes = fileInputStream.read();
                if (bytes < min) {
                    min = bytes;
                }

            }
            System.out.println(min);
        }
    }
}
