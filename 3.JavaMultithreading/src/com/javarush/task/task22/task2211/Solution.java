package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] buffer;
        try (FileInputStream input = new FileInputStream(args[0])) {
            buffer = new byte[input.available()];
               input.read(buffer);
        }
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        String str = new String(buffer, windows1251);
        try (FileOutputStream output = new FileOutputStream(args[1])) {
            output.write(str.getBytes(utf8));
        }


    }
}
