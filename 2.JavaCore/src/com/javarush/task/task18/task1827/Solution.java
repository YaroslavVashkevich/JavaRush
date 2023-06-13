package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        int maxId = 0;
        try (FileReader in = new FileReader(source);
             BufferedReader reader = new BufferedReader(in);
             FileWriter out = new FileWriter(source, true);
             BufferedWriter writer = new BufferedWriter(out)
        ) {
            while (reader.ready()) {
                list.add(Integer.parseInt(reader.readLine().substring(0, 8).trim()));
            }
            if (args.length > 0 && args[0].equals("-c")) {
                StringBuilder id = new StringBuilder(Integer.toString(Collections.max(list) + 1));
                StringBuilder productName = new StringBuilder(args[1]);
                StringBuilder price = new StringBuilder(args[2]);
                StringBuilder quantity = new StringBuilder(args[3]);
                String str = add(id, 8) + add(productName, 30) + add(price, 8) + add(quantity, 4);
                writer.write("\n" + str);
            }
        }
    }
    public static String add(StringBuilder id, int size) {
        while (id.length() < size) {
            id.append(" ");
        }
        return id.toString();
    }
}
