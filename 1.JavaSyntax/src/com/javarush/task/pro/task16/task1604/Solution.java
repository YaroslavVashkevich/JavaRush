package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1980, 02, 15);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }
    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String day = switch (dayOfWeek){
            case 1: yield "Воскресенье";
            case 2: yield "Понедельник";
            case 3: yield "Вторник";
            case 4: yield "Среда";
            case 5: yield "Четверг";
            case 6: yield "Пятница";
            case 7: yield "Суббота";
            default: yield "";
        };
        return day;
    }
}
