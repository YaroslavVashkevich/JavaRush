package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                return;
            }
            String resultFileName = args[0];
            int filePartCount = args.length - 1;
            String[] fileNamePart = new String[filePartCount];
            for (int i = 0; i < fileNamePart.length; i++) {
                fileNamePart[i] = args[i + 1];
            }
            Arrays.sort(fileNamePart);

            List<FileInputStream> fileInputStreams = new ArrayList<>();
            for (int i = 0; i < filePartCount; i++) {
                fileInputStreams.add(new FileInputStream(fileNamePart[i]));
            }

            SequenceInputStream sequenceInputStream =
                    new SequenceInputStream(Collections.enumeration(fileInputStreams));

            ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
            byte[] buff = new byte[1024 * 1024];
            while (zipInputStream.getNextEntry() != null){
                int count;
                while ((count = zipInputStream.read(buff)) != -1){
                    fileOutputStream.write(buff, 0, count);
                }
            }
            sequenceInputStream.close();
            zipInputStream.close();
            fileOutputStream.close();
        }catch (Exception ex){
            ex.getMessage();
        }
    }
}
