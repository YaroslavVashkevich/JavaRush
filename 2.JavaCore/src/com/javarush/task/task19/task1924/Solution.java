package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String file = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                int count = 0;
                int count1 = 0;
                String s2 = "";
                String s3 = "";
                String str1 = "";
                String str = bufferedReader.readLine();
                if (str.endsWith(",") || str.endsWith(".") || str.endsWith("!") || str.endsWith("?") || str.endsWith(";") || str.endsWith(":")){
                    s3 = str.substring(str.length()- 1);
                    count1++;
                    str = str.substring(0, str.length() - 1);

                }
                String[] array = str.split(" ");
                for (String s : array) {
                    String s1 = s;
                    count = 0;
                    if (s1.endsWith(",") || s1.endsWith(".") || s1.endsWith("!") || s1.endsWith("?") || s1.endsWith(";") || s1.endsWith(":")){
                        s2 = s1.substring(s1.length()- 1);
                        count++;
                        s1 = s1.substring(0, s1.length() - 1);
                    }
                if (!s1.matches("-?\\d+(\\.\\d+)?")){
                    if (count > 0) {
                        str1 += s1 + s2 +" ";
                    } else{
                        str1 += s1 + " ";
                    }
                }else {
                    int i = Integer.parseInt(s1);
                    if (count > 0) {
                        if (i >= 0 && i <= 12) {
                            str1 += map.get(i) + s2 + " ";
                        } else {
                            str1 += i + s2 + " ";
                        }
                    } else{
                        if (i >= 0 && i <= 12) {
                            str1 += map.get(i) + " ";
                        } else {
                            str1 += i + " ";
                        }

                    }
                }
                }
                if (count1 > 0) {
                    str1 = str1.trim() + s3;
                    System.out.println(str1);
                } else{
                    System.out.println(str1);
                }
            }
        }
    }
}