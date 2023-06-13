package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            while (fileInputStream.available() > 0) {
                int bytes = fileInputStream.read();
                set.add(bytes);
                }
        }
        set.forEach(x -> System.out.print(x + " "));
        }
    }
