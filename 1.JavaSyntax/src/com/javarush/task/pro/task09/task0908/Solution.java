package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == "" || binaryNumber == null || checkHex(binaryNumber)) {
            return "";
        } else {
            return toDecimalFromHex(binaryNumber);
        }
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == "" || hexNumber == null || checkBinary(hexNumber)) {
            return "";
        } else {
            return toDecimalFromBinary(hexNumber);
        }
    }


    public static boolean checkHex(String binaryNumber) {
        int count = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '0' || binaryNumber.charAt(i) == '1') {
                count++;
            }
        }
        if (binaryNumber.length() == count)
            return false;
        return true;
    }

    public static boolean checkBinary(String hexNumber) {
        int count = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            for (int j = 0; j < HEX.length(); j++) {
                if (hexNumber.charAt(i) == HEX.charAt(j)) {
                    count++;
                }
            }
        }
        if (hexNumber.length() == count)
            return false;
        return true;
    }

    public static String toDecimalFromHex(String binaryNumber) {
        int decimalNumber = 0;
        String hexNumber = "";
        for (int i = 0; i < binaryNumber.length(); i++) {
            decimalNumber = decimalNumber + Integer.parseInt(String.valueOf(binaryNumber.charAt(binaryNumber.length() - i - 1))) * (int) Math.pow(2, i);
        }
        while (decimalNumber != 0) {
            hexNumber = HEX.charAt(decimalNumber % 16) + hexNumber;
            decimalNumber = decimalNumber / 16;
        }
        return hexNumber;
    }

    public static String toDecimalFromBinary(String hexNumber) {
        long decimalNumber = 0;
        String binaryNumber = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            decimalNumber = decimalNumber + Character.getNumericValue(hexNumber.charAt(hexNumber.length() - i - 1)) * (long) Math.pow(16, i);
        }
        System.out.println(decimalNumber);
        while (decimalNumber != 0) {
            binaryNumber = (decimalNumber % 2) + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

}
