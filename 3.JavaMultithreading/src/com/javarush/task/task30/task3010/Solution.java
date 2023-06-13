package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if(args[0].length() != 0 && args[0].length()<256)
                System.out.println(getRadix(args[0]));//напишите тут ваш код
        }catch (Exception ex){

        }
    }
    private static String getRadix(String value){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i < 37; i++) {
            try{
                BigInteger integer = new BigInteger(value, i);
                set.add(i);
            }catch (Exception ex){

            }
        }
        return set.isEmpty()?"incorrect" : String.valueOf(set.first());
    }
}