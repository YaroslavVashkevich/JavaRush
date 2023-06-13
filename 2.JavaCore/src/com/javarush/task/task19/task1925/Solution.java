package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String str = "";
        try (FileReader fileReader = new FileReader(args[0]);
             FileWriter writer = new FileWriter(args[1]);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String[] array = bufferedReader.readLine().split("[ \n]");
                for (String s : array) {
                    if (s.length() > 6){
                        str += s + ",";
                    }
                }
            }
            str = str.substring(0, str.lastIndexOf(","));
            writer.write(str);
        }

    }
}
