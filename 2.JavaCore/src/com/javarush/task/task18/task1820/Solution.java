package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        String str = "";
        try (FileReader reader = new FileReader(file1);
             FileWriter writer = new FileWriter(file2)) {
            while (reader.ready()) {
                str = str + (char) reader.read();
            }
            String[] array = str.trim().split(" ");
            array = Arrays.stream(array).map(x -> Double.parseDouble(x)).map(x -> Math.round(x)).map(x -> Long.toString(x)).toArray(String[]::new);
            str = Arrays.toString(array).replaceAll("[\\[,\\]]", "").trim();
            writer.write(str);
        }
    }
}
