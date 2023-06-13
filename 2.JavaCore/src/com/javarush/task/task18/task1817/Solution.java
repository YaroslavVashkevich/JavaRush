package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String str = "";
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                str = str + (char)reader.read();
            }
        }
        double all = str.length();
        double space = (str.replaceAll("[^\\s]", "")).length();
        double ratio = ((double)Math.round((space * 100) * 100 / all)) / 100;
        System.out.println(ratio);

    }
}
