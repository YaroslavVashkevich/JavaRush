package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        try (FileInputStream input1 = new FileInputStream(file1);
             FileInputStream input2 = new FileInputStream(file2)) {
            byte[] buffer1 = new byte[input1.available()];
            byte[] buffer2 = new byte[input2.available()];
            input1.read(buffer1);
            input2.read(buffer2);

            try(FileOutputStream output = new FileOutputStream(file1)) {
                output.write(buffer2);
                output.write(buffer1);
            }
        }
    }
}
