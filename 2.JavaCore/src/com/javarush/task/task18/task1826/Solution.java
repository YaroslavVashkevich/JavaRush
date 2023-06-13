package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        try (FileInputStream input = new FileInputStream(args[1]);
             FileOutputStream output = new FileOutputStream(args[2])) {
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            if (args[0].equals("-e")) {
                crypt(buffer, output);
            } else if (args[0].equals("-d")) {
                crypt(buffer, output);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crypt(byte[] buffer, FileOutputStream output) throws IOException {
        byte password = 125;
        byte[] newBuffer = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++)
            newBuffer[i] = (byte) (buffer[i] ^ password);
        output.write(newBuffer);
    }
}
