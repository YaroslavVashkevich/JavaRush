package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String file1 = "";
        String file2 = "";
        String result = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file1);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                result += bufferedReader.readLine();
            }
        }

        result = result.replaceAll("[.]", "!");
        try (FileWriter fileWriter = new FileWriter(file2);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(result);
        }
    }
}
