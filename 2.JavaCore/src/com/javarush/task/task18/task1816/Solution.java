package com.javarush.task.task18.task1816;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "";
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                str = str + (char)reader.read();
            }
        }
        System.out.println((str.replaceAll("[^a-zA-Z]", "")).length());
    }
}
