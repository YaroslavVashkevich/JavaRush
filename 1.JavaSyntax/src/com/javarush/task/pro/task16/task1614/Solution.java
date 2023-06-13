package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

import static java.time.Instant.ofEpochMilli;
import static java.time.Instant.ofEpochSecond;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        //напишите тут ваш код

        return ofEpochMilli(Long.MAX_VALUE) ;
    }

    static Instant getMaxFromSeconds() {
        //напишите тут ваш код

        return ofEpochSecond(Instant.MAX.getEpochSecond());
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишите тут ваш код

        return ofEpochSecond(Instant.MAX.getEpochSecond(), Instant.MAX.getNano());
    }
}
