package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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
        Double value = Collections.max(map.values());
        for (Map.Entry<String, Double> tmp : map.entrySet()) {
            if(Double.valueOf(tmp.getValue()).equals(value)){
                System.out.println(tmp.getKey());
            }
        }

    }
}
