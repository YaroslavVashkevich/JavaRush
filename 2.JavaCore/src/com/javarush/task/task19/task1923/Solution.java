package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String str = "";
        try (FileReader fileReader = new FileReader(args[0]);
             FileWriter writer = new FileWriter(args[1]);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String[] array = bufferedReader.readLine().split(" ");
                for (String s : array) {
                    String str1 = s.replaceAll("\\D", "");
                    if (str1.length() > 0){
                      str += s + " ";
                    }
                }
            }
            str = str.trim();
            writer.write(str);
        }
    }
}
