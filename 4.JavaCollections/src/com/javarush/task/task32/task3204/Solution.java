package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Random random = new Random();
        int length = 0;
        while (length != 8) {
            baos.write(48 + random.nextInt(10));
            length++;
            baos.write(65 + random.nextInt(26));
            length++;
            if(length >= 8)break;
            baos.write(97 + random.nextInt(26));
            length++;
        }
        return baos;
    }}