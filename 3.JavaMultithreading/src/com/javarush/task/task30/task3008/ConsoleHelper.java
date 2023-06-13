package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);

    }

    public static String readString() {
        boolean isStart = true;
        String str = "";
        while (isStart){
            try {
                str = bufferedReader.readLine();
                isStart = false;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
    }
        return str;
    }

    public static int readInt() throws IOException {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return Integer.parseInt(readString());
        }
    }


}
