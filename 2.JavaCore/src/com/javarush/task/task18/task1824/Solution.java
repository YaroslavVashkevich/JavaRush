package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        while (true) {
            try(FileInputStream input = new FileInputStream(source)){

            } catch (FileNotFoundException e) {
                System.out.println(source);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            source = sc.nextLine();
        }
    }
}
