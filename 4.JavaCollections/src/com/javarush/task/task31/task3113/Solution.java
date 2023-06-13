package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    static int countDirectories = 0;
    static int countFiles = 0;
    static long bytes = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path file = Paths.get(br.readLine());
        br.close();
        if(Files.isDirectory(file)){
            Files.walkFileTree(file, new MyVisitor());

            System.out.println("Всего папок - " + (countDirectories - 1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + bytes);
        }else{
            System.out.println(file.toAbsolutePath().toString() + " - не папка");
        }

    }
    public static class MyVisitor extends SimpleFileVisitor{

        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            countFiles++;
            bytes+=attrs.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
            countDirectories++;
            return FileVisitResult.CONTINUE;
        }
    }
}
