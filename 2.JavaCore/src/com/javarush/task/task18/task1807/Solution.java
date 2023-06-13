package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            int count = 0;
            while (fileInputStream.available() > 0) {
                int bytes = fileInputStream.read();
                if ((char)bytes == ',') {
                    count++;
                }

            }
            System.out.println(count);
        }
    }
}
