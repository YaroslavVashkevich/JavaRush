package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String str = "";
        try (FileReader in = new FileReader(source);
             BufferedReader reader = new BufferedReader(in);) {
            int idNew = Integer.parseInt(args[0].trim());
            while (reader.ready()) {
                String line = reader.readLine();
                int id = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                if (id == idNew) {
                    str = line;
                }
            }
        }
        System.out.println(str);
    }

}
