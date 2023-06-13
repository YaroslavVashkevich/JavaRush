package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = "";
        String line = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                line += bufferedReader.readLine();
            }
        }

        StringBuilder result;
        if (line.isEmpty()) {
            result = getLine();
        } else {
            result = getLine(line.split(" "));
        }
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) {
            return new StringBuilder();
        } else {
            sb.append(list.get(0));
            list.remove(0);

            while (!list.isEmpty()) {
                int size = sb.length();
                for (int i = 0; i < list.size(); i++) {
                    if (Character.toLowerCase(sb.charAt(0)) == list.get(i).toLowerCase().charAt(list.get(i).length() - 1)) {
                        sb.insert(0, list.get(i) + " ");
                        list.remove(i);
                        i--;
                    } else {
                        if (Character.toLowerCase(sb.charAt(sb.length() - 1)) == list.get(i).toLowerCase().charAt(0)) {
                            sb.append(" " + list.get(i));
                            list.remove(i);
                            i--;
                        }
                    }
                }
                if (size == sb.length()) {
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(" ").append(list.get(i));
                        list.remove(i);
                        i--;
                    }
                }
            }
            return sb;
        }
    }
}
