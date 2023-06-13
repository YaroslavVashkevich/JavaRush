package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        String file3 = sc.nextLine();
        try (FileOutputStream output = new FileOutputStream(file1, true);
             FileInputStream input1 = new FileInputStream(file2);
             FileInputStream input2 = new FileInputStream(file3)) {
            byte[] buffer1 = new byte[input1.available()];
            byte[] buffer2 = new byte[input2.available()];
            input1.read(buffer1);
            input2.read(buffer2);
            output.write(buffer1);
            output.write(buffer2);
        }
    }
}
