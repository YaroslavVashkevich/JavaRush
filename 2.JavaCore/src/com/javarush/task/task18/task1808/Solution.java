package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        String file3 = sc.nextLine();
        try (FileInputStream input = new FileInputStream(file1);
             FileOutputStream output1 = new FileOutputStream(file2);
             FileOutputStream output2 = new FileOutputStream(file3)) {
            byte[] buffer = new byte[input.available()];
            int real = input.read(buffer);
            byte[] buffer1 = null;
            byte[] buffer2= null;
            if (real % 2 == 0) {
                buffer1 = Arrays.copyOf(buffer, real / 2);
                buffer2 = Arrays.copyOfRange(buffer, real / 2, real);
            } else if (real % 2 != 0) {
               buffer1 = Arrays.copyOf(buffer, real / 2 + 1);
                buffer2 = Arrays.copyOfRange(buffer, real / 2 + 1, real);
            }
            output1.write(buffer1, 0, buffer1.length);
            output2.write(buffer2, 0, buffer2.length);
        }
    }
}
