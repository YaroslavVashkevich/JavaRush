package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
    static {
        try(InputStream stream = new FileInputStream(Statics.FILE_NAME);
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready())
            {
                String line = bufferedReader.readLine();
                lines.add(line);
            }} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
