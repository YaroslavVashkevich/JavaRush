package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        try(InputStream stream = new FileInputStream(sc.nextLine());
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready())
            {
                String line = bufferedReader.readLine();
                list.add(Integer.parseInt(line));
            }
        }
        list.stream().filter(x -> x % 2 == 0).sorted().forEach(System.out::println);
    }
}