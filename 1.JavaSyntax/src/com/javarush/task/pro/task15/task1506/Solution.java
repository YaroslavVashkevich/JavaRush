package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        List<String> list = null;
        try {
            list = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        for (String str : list) {
            line = line + str;
        }
        char[] array = line.toCharArray();

        for (char word : array) {
            if (word != ' ' && word != ',' && word != '.') {
                System.out.print(word);
            }
        }
    }
}

