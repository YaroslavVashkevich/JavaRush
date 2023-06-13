package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "";
        String file2 = "";
        String result = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file1)) {
            while (fileReader.ready()) {
                result += (char)fileReader.read();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (i % 2 != 0) {
                stringBuilder.append(result.charAt(i));
            }
        }
        try (FileWriter fileWriter = new FileWriter(file2)) {
            fileWriter.write(stringBuilder.toString());
        }
    }
}
