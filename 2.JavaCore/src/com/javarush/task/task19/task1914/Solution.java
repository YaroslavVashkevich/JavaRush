package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] array = outputStream.toString().split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);
        String str = "";
        if (array[1].equals("+")) {
            str = array[0] + " + " + array[2] + " = " + (a + b);
        } else if (array[1].equals("-")) {
            str = array[0] + " - " + array[2] + " = " + (a - b);
        } else if (array[1].equals("*")) {
            str =  array[0] + " * " + array[2] + " = " + (a * b);
        }
        System.out.println(str);
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

