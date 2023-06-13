package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        //напишите тут ваш код
        byte[] out = outputStream.toByteArray();
        byte letter;
        for (int i = 0; i < out.length / 2; i++) {
            letter = out[i];
            out[i] = out[out.length - i - 1];
            out[out.length - 1 - i] = letter;
        }
        outputStream.reset();
        outputStream.write(out);
        String result = outputStream.toString();
        System.out.println(result);
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}