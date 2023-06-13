package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        int i = url.indexOf("?");
        String newStr = url.substring(i + 1);
        List<String> list = new ArrayList<>(Arrays.asList(newStr.split("&")));
        list.stream().map(x -> {
            if (x.contains("=")) {
                return x.substring(0, x.indexOf("="));
            }
            return x;
        }).forEach(x -> System.out.print(x + " "));

        List<String> newList = list.stream().filter(x ->
                x.contains("obj")).map(x ->
                x.substring(4)
        ).collect(Collectors.toList());

        for (String s : newList) {
            if (isNumeric(s)) {
                alert(Double.parseDouble(s));
            } else {
                alert(s);
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
