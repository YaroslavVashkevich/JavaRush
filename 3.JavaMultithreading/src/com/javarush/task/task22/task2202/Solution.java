package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null || countSpace(string) < 4) {
            throw new TooShortStringException();
        }
        string = string.substring((string.indexOf(" ")) + 1);
        int count = 0;
        int index = 0;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                count++;
            }
            if (count == 3) {
                break;
            }
            index++;
        }
        String begin = string.substring(0, index + 1);
        String end = string.substring(index + 1);

        Pattern pattern = Pattern.compile(".+?[ .!,?;:+*%]");
        Matcher matcher = pattern.matcher(end);
        while (matcher.find()) {
            end = matcher.group().trim();
            break;
        }
        return begin + end;
    }

    public static class TooShortStringException extends RuntimeException {
    }

    public static int countSpace(String string){
        int countSpace = 0;
        for (char ch : string.toCharArray()) {
            if (ch == ' ') {
                countSpace++;
            }
        }
        return countSpace;
    }
}
