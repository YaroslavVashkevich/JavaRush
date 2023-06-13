package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))) {
            while (bufferedReader.ready()) {
                allLines.add(bufferedReader.readLine());
            }
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file2))) {
            while (bufferedReader.ready()) {
                forRemoveLines.add(bufferedReader.readLine());
            }
        }
        solution.joinData();
        sc.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}
