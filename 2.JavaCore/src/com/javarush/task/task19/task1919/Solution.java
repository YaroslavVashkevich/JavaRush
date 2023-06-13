package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<String, Double> map = new TreeMap<>();
        try (FileReader fileReader = new FileReader(args[0]);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String[] str = bufferedReader.readLine().split(" ");
                if (map.containsKey(str[0])){
                    Double value = map.get(str[0]) + Double.parseDouble(str[1]);
                    map.put(str[0],value);
                }else {
                    map.put(str[0], Double.parseDouble(str[1]));
                }
            }
        }
        map.forEach((x, y) -> System.out.println(x + " " + y));
    }
}
