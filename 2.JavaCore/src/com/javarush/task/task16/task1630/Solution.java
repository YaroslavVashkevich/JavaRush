package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        Scanner sc = new Scanner(System.in);
        firstFileName = sc.nextLine();
        secondFileName = sc.nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String file = "";
        String line = "";

        @Override
        public void setFileName(String fullFileName) {
            file = fullFileName;
        }

        @Override
        public String getFileContent() {
            return line;
        }

        @Override
        public void run() {
            try (InputStream stream = new FileInputStream(file);
                 InputStreamReader reader = new InputStreamReader(stream);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                while (bufferedReader.ready()) {
                    line = line + bufferedReader.readLine() +" ";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //g:\\file1.txt
            //g:\\file2.txt


        }
    }
}
