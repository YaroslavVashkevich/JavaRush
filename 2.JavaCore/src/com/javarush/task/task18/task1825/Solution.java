package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Byte[]> map = new TreeMap<>();
        String source = sc.nextLine();
        String destination = source.substring(0, source.lastIndexOf("."));
        while (!source.equals("end")) {
            try (FileInputStream fileInputStream = new FileInputStream(source);
                 BufferedInputStream input = new BufferedInputStream(fileInputStream)) {
                Integer part = Integer.parseInt(source.substring(source.lastIndexOf(".") + 1).replaceAll("\\D", ""));
                byte[] buffer = new byte[fileInputStream.available()];
                while (input.available() > 0) {
                    input.read(buffer);
                }
                Byte[] bytes = new Byte[buffer.length];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = buffer[i];
                }
                map.put(part, bytes);
            }
            source = sc.nextLine();
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(destination);
             BufferedOutputStream output = new BufferedOutputStream(fileOutputStream)) {
            for (Map.Entry<Integer, Byte[]> tmp : map.entrySet()) {
                byte[] bytes = new byte[tmp.getValue().length];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = tmp.getValue()[i];
                }
                output.write(bytes);
            }
        }
    }
}
