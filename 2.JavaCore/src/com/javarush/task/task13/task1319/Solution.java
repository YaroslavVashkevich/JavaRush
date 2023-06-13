package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();

        String str = "";
        boolean isRun = true;
        while (isRun){
            String part = sc.nextLine();
            if (part.equals("exit")) {
                str = str + part + "\n";
                isRun = false;
            }else {
                str = str + part + "\n";
            }
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(src))){
            bufferedWriter.write(str);
        }

    }
}
