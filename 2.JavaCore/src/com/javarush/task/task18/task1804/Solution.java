package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(sc.nextLine())) {
            Map<Integer, Integer> hashMap = new LinkedHashMap<>();
            while (fileInputStream.available() > 0) {
                Integer key = fileInputStream.read();
                Integer value = hashMap.get(key);
                hashMap.put(key, value == null ? 1 : value + 1);
            }
            for (Map.Entry<Integer, Integer> tmp : hashMap.entrySet()) {
                if (tmp.getValue() == Collections.min(hashMap.values())) {
                    System.out.print(tmp.getKey() + " ");
                }
            }
        }
    }
}