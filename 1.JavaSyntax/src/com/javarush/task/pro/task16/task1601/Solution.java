package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(80, 02, 15);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        int day = date.getDay();
        String str = switch (day) {
            case 1:
                yield "Понедельник";
            case 2:
                yield "Вторник";
            case 3:
                yield "Среда";
            case 4:
                yield "Четверг";
            case 5:
                yield "Пятница";
            case 6:
                yield "Суббота";
            case 0:
                yield "Воскресенье";
            default:
                yield "";
        };
        return str;
    }

}
