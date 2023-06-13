package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String file1 = "";
        String result = "";
        int count = 0;
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file1 = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file1)) {
            while (fileReader.ready()) {
                result += (char)fileReader.read();
            }
        }
        result = result.replaceAll("[\\]\\[\'\".!?;:()?,-/<>{}*&^%$#@~+=_]", " ").replaceAll("\\s+", " ");
        String[] array = result.split(" ");
        for (String s:array) {
            if (s.equals("world")){
                count++;
            }
        }
        System.out.println(count);
    }
}
