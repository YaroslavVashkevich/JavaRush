package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        try (FileReader fileReader = new FileReader(args[0]);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                String name = str.replaceAll("\\d", " ").trim();
                String[] date = str.replaceAll("\\D", " ").trim().split(" ");
                Date date1 = new Date(Integer.parseInt(date[2]) - 1900, Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]));
                PEOPLE.add(new Person(name, date1));
            }
        }
    }
}
