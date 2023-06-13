package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        try (FileInputStream input = new FileInputStream(file1);
             FileOutputStream output = new FileOutputStream(file2)) {
            byte[] buffer = new byte[input.available()];
            int real = input.read(buffer);
            for (int i = 0; i < real / 2; i++) {
                byte t = buffer[i];
                buffer[i] = buffer[real - i - 1];
                buffer[real - i - 1] = t;
            }
            output.write(buffer, 0, real);
        }
    }
}
