package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader(args[0])) {
            Map<Integer, Integer> hashMap = new TreeMap<>();
            while (reader.ready()) {
                Integer key = reader.read();
                Integer value = hashMap.get(key);
                hashMap.put(key,value == null ? 1 : value + 1);
            }
           hashMap.forEach((x, y) -> System.out.println((char)x.intValue() + " " + y));
        }
    }
}
