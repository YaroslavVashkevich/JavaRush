package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();

        try(InputStream stream = new FileInputStream(src);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready())
            {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
        }



    }
}