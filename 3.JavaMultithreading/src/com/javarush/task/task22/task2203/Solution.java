package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/


public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int count = 0;
        char[] ch = string.toCharArray();
        for (char c : ch) {
            if (c == '\t') {
                count++;
            }
        }
        if (count < 2) {
            throw new TooShortStringException();
        }

        string = string.substring((string.indexOf("\t")) + 1);
        string = string.substring(0, string.indexOf("\t"));

        return string;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
