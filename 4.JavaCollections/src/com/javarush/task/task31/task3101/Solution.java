package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    List<File> fileList = new ArrayList<>();
    public static void main(String[] args) {
        Solution s = new Solution();
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        s.directoryControl(path);

        Collections.sort(s.fileList, (o1, o2) -> {
            String f1 = o1.toString();
            String f2 = o2.toString();
            return f1.compareTo(f2);
        });

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        s.fileList.remove(resultFileAbsolutePath.getName());

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(allFilesContent))) {
            for (File file : s.fileList) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while (br.ready()) {
                    bw.write(br.readLine() + "\n");
                }
                br.close();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void directoryControl(File path){
        for(File file : path.listFiles()){
            if(file.isDirectory()){
                if(file.listFiles().length != 0){
                    directoryControl(file);
                }
                else {
                    continue;
                }
            }
            else{
                if(file.length()<=50){
                    fileList.add(file);
                }
                else {
                    continue;
                }
            }
        }
    }
}
