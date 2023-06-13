package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder word1 = new StringBuilder();
        StringBuilder word2 = new StringBuilder();
        byte[] buffer;
        try(FileInputStream input = new FileInputStream(sc.nextLine()))
        {
            buffer = new byte[input.available()];
            input.read(buffer);
            }
        String line = new String(buffer, "UTF-8");

        String[] strings = line.split("[\\s\\n]");
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        int i = 0;
        while (i < list.size()) {
            for (int j = i + 1; j < list.size(); j++) {
                word1.append(list.get(i));
                word2.append(list.get(j)).reverse();
                if (word1.toString().equals(word2.toString())) {
                    result.add(new Pair(word1.toString(), word2.reverse().toString()));
                    list.remove(i);
                    list.remove(j - 1);
                    word1.setLength(0);
                    word2.setLength(0);
                    i--;
                    break;
                }
                word1.setLength(0);
                word2.setLength(0);
            }
            i++;
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
