package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String word : words) {
            int startIndexX = 0;
            int startIndexY = 0;
            char[] chars = word.toCharArray();
            char start = chars[0];
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if ((char) crossword[i][j] == start) {
                        startIndexX = i;
                        startIndexY = j;
                        addWord(startIndexX, startIndexY, word, crossword, list);
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

    public static void addWord(int startIndexX, int startIndexY, String word, int[][] crossword, List<Word> list) {
        char[] chars = word.toCharArray();
        char twoChar = chars[1];
        if (startIndexX - 1 >= 0 && crossword[startIndexX - 1][startIndexY] == twoChar) {
            String str = "";
            int endIndexX = startIndexX - (chars.length - 1);
            if (endIndexX >= 0) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX - j][startIndexY];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, startIndexY, list);
                }
            }
        }
        if (startIndexX + 1 <= crossword.length - 1 && crossword[startIndexX + 1][startIndexY] == twoChar) {
            String str = "";
            int endIndexX = startIndexX + (chars.length - 1);
            if (endIndexX <= crossword.length - 1) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX + j][startIndexY];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, startIndexY, list);
                }
            }
        }
        if (startIndexY - 1 >= 0 && crossword[startIndexX][startIndexY - 1] == twoChar) {
            String str = "";
            int endIndexY = startIndexY - (chars.length - 1);
            if (endIndexY >= 0) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX][startIndexY - j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, startIndexX, endIndexY, list);
                }
            }
        }
        if (startIndexY + 1 <= crossword[startIndexX].length - 1 && crossword[startIndexX][startIndexY + 1] == twoChar) {
            String str = "";
            int endIndexY = startIndexY + (chars.length - 1);
            if (endIndexY <= crossword[startIndexX].length - 1) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX][startIndexY + j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, startIndexX, endIndexY, list);
                }
            }
        }
        if (startIndexX - 1 >= 0 && startIndexY + 1 <= crossword[startIndexX].length - 1 && crossword[startIndexX - 1][startIndexY + 1] == twoChar) {
            String str = "";
            int endIndexX = startIndexX - (chars.length - 1);
            int endIndexY = startIndexY + (chars.length - 1);
            if (endIndexX >= 0 && endIndexY <= crossword[endIndexX].length - 1) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX - j][startIndexY + j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, endIndexY, list);
                }
            }
        }
        if (startIndexX + 1 <= crossword.length - 1 && startIndexY + 1 <= crossword[startIndexX].length - 1 && crossword[startIndexX + 1][startIndexY + 1] == twoChar) {
            String str = "";
            int endIndexX = startIndexX + (chars.length - 1);
            int endIndexY = startIndexY + (chars.length - 1);
            if (endIndexX <= crossword.length - 1 && endIndexY <= crossword[endIndexX].length - 1) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX + j][startIndexY + j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, endIndexY, list);
                }
            }
        }
        if (startIndexX + 1 <= crossword.length - 1 && startIndexY - 1 >= 0 && crossword[startIndexX + 1][startIndexY - 1] == twoChar) {
            String str = "";
            int endIndexX = startIndexX + (chars.length - 1);
            int endIndexY = startIndexY - (chars.length - 1);
            if (endIndexX <= crossword.length - 1 && endIndexY >= 0) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX + j][startIndexY - j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, endIndexY, list);
                }
            }
        }
        if (startIndexX - 1 >= 0 && startIndexY - 1 >= 0 && crossword[startIndexX - 1][startIndexY - 1] == twoChar) {
            String str = "";
            int endIndexX = startIndexX - (chars.length - 1);
            int endIndexY = startIndexY - (chars.length - 1);
            if (endIndexX >= 0 && endIndexY >= 0) {
                for (int j = 0; j < chars.length; j++) {
                    str = str + (char) crossword[startIndexX - j][startIndexY - j];
                }
                if (str.equals(word)) {
                    add(word, startIndexX, startIndexY, endIndexX, endIndexY, list);
                }
            }
        }

    }

    public static void add(String word, int startIndexX, int startIndexY, int endIndexX, int endIndexY, List<Word> list) {
        Word wordList = new Word(word);
        wordList.setStartPoint(startIndexY, startIndexX);
        wordList.setEndPoint(endIndexY, endIndexX);
        list.add(wordList);
    }

}
