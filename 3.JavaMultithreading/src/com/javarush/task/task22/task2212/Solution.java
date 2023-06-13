package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        return (telNumber == null) ? false : !(Pattern.matches("((?!^\\+?(\\d+)?(\\(\\d{3}\\))?\\d+$).)*$|^((?!^[^+\\d]?(\\d\\D?){10}$|^\\+\\D?(\\d\\D?){12}$).)*", telNumber));
    }

    public static void main(String[] args) {

    }
}
