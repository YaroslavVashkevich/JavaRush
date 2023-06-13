package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String file1 = "";
        String file2 = "";
        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }
        read(result1, file1);
        read(result2, file2);
        int i = 0;
        while (Math.max(result1.size(), result2.size()) != i) {
            if (i >= result2.size()) {
                result2.add(null);
                lines.add(new LineItem(Type.REMOVED, result1.get(i)));
            } else if (i >= result1.size()) {
                result1.add(null);
                lines.add(new LineItem(Type.ADDED, result2.get(i)));
            } else if (result1.get(i).equals(result2.get(i))) {
                lines.add(new LineItem(Type.SAME, result1.get(i)));
            } else if (!result1.get(i).equals(result2.get(i))
                    && result1.get(i + 1).equals(result2.get(i))) {
                result2.add(i, null);
                lines.add(new LineItem(Type.REMOVED, result1.get(i)));
            } else if (!result1.get(i).equals(result2.get(i))
                    && result1.get(i).equals(result2.get(i + 1))) {
                result1.add(i, null);
                lines.add(new LineItem(Type.ADDED, result2.get(i)));
            }
            i++;
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

    public static void read(List<String> list, String file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
