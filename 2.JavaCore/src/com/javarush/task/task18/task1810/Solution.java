package com.javarush.task.task18.task1810;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String src = sc.nextLine();
            FileInputStream input = new FileInputStream(src);
            File file = new File(src);
            if (file.length() < 1000) {
                input.close();
                throw new DownloadException();
            }
        }
    }
    public static class DownloadException extends Exception {

    }
}
