package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int countDigits = 0;
        char[] array = string.toCharArray();
        for (char charArray: array) {
            if (Character.isDigit(charArray)){
                countDigits++;
            }
        }
        return countDigits;
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int countLetters = 0;
        char[] array = string.toCharArray();
        for (char charArray: array) {
            if (Character.isLetter(charArray)){
                countLetters++;
            }
        }
        return countLetters;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int countSpaces = 0;
        char[] array = string.toCharArray();
        for (char charArray: array) {
            if (Character.isSpaceChar(charArray)){
                countSpaces++;
            }
        }
        return countSpaces;
    }
}
