package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String path1 = scanner.nextLine();
        String path2 = scanner.nextLine();
        try (InputStream input = Files.newInputStream(Path.of(path1));
             OutputStream output = Files.newOutputStream(Path.of(path2))) {

            byte[] bytes = input.readAllBytes();
            byte elment;
            for (int i = 0; i < bytes.length; i++) {
                if ((i + 1) % 2 != 0 && (i + 1 != bytes.length)) {
                    elment = bytes[i + 1];
                    bytes[i + 1] = bytes[i];
                    bytes[i] = elment;
                }
            }
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

