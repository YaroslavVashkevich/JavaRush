package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] array = str.split(" ");
            Person person = new Person(array[1],array[2], array[0], new Date(Integer.parseInt(array[5]) - 1900, Integer.parseInt(array[4]) - 1, Integer.parseInt(array[3])));
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
