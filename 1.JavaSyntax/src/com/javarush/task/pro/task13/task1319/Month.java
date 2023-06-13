package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths() {
        Month[] value = {Month.DECEMBER, Month.JANUARY, Month.FEBRUARY};
        return value;
    }

    public static Month[] getSpringMonths() {
        Month[] value = {Month.MARCH, Month.APRIL, Month.MAY};
        return value;
    }

    public static Month[] getSummerMonths() {
        Month[] value = {Month.JUNE, Month.JULY, Month.AUGUST};
        return value;
    }

    public static Month[] getAutumnMonths() {
        Month[] value = {Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER};
        return value;
    }


}
