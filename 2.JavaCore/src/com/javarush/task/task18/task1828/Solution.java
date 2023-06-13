package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        List<Integer> list = new ArrayList<>();

        if (args.length > 0 && args[0].equals("-c")) {
            try (FileReader in = new FileReader(source);
                 BufferedReader reader = new BufferedReader(in);
                 FileWriter out = new FileWriter(source, true);
                 BufferedWriter writer = new BufferedWriter(out)) {
                while (reader.ready()) {
                    list.add(Integer.parseInt(reader.readLine().substring(0, 8).trim()));
                }
                StringBuilder id = new StringBuilder(Integer.toString(Collections.max(list) + 1));
                StringBuilder productName = new StringBuilder(args[1]);
                StringBuilder price = new StringBuilder(args[2]);
                StringBuilder quantity = new StringBuilder(args[3]);
                String str = add(id, 8) + add(productName, 30) + add(price, 8) + add(quantity, 4);
                writer.write("\n" + str);
            }
        } else if (args.length > 0 && args[0].equals("-u")) {
            String str = "";
            try (FileReader in = new FileReader(source);
                 BufferedReader reader = new BufferedReader(in);
            ) {
                int idDel = Integer.parseInt(args[1].trim());
                while (reader.ready()) {
                    String line = reader.readLine();
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id != idDel) {
                        str = str + line + "\n";
                    }else{
                        StringBuilder idU = new StringBuilder(args[1]);
                        StringBuilder productName = new StringBuilder(args[2]);
                        StringBuilder price = new StringBuilder(args[3]);
                        StringBuilder quantity = new StringBuilder(args[4]);
                        String strU = add(idU, 8) + add(productName, 30) + add(price, 8) + add(quantity, 4);
                        str = str + strU + "\n";
                    }
                }
                if (!str.isEmpty()) {
                    str = str.substring(0, str.lastIndexOf("\n"));
                }
            }
            try (FileWriter out = new FileWriter(source);
                 BufferedWriter writer = new BufferedWriter(out)) {
                writer.write(str);
            }

        } else if (args.length > 0 && args[0].equals("-d")) {
            String str = "";
            try (FileReader in = new FileReader(source);
                 BufferedReader reader = new BufferedReader(in);
            ) {
                int idDel = Integer.parseInt(args[1].trim());
                while (reader.ready()) {
                    String line = reader.readLine();
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id != idDel) {
                        str = str + line + "\n";
                    }
                }
                if (!str.isEmpty()) {
                    str = str.substring(0, str.lastIndexOf("\n"));
                }
            }
            try (FileWriter out = new FileWriter(source);
                 BufferedWriter writer = new BufferedWriter(out)) {
                writer.write(str);
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
