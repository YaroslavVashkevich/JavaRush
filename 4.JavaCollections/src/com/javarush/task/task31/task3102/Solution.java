package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> allFilesAbsolutePaths = new LinkedList<>();
        Queue<File> queue = new LinkedList<>();

        queue.offer(new File(root));
        while (!queue.isEmpty()){
            File file = queue.poll();
            if(file.isDirectory()){
                for(File f : file.listFiles()){
                    queue.offer(f);
                }
            }else{
                allFilesAbsolutePaths.add(file.getAbsolutePath());
            }
        }
        return allFilesAbsolutePaths;
    }

    public static void main(String[] args) throws IOException {
        List<String> l = getFileTree("a:/jrush/");
        System.out.println(l);
    }
}
