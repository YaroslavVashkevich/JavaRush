package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        String file = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                int count = 0;
                String[] array = str.split(" ");
                for (String s : array) {
                    if (words.contains(s)){
                        count++;
                    }
                }
                if (count == 2){
                    System.out.println(str);
                }
            }
        }
    }
}
