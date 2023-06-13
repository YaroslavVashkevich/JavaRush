package com.javarush.task.task14.task1419;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] ints = new int[]{1,2,3,4,5};
            System.out.println(ints[5]);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("c:\\text.txt");

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Integer x = null;
            System.out.println(x/2);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            exceptions.get(20);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String str = "qqq";
            Integer i = Integer.parseInt(str);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object[] o = new Integer[3];
            o[0] = 4.4;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {

            Object o = new Object();
            String s = (String)o;

            System.out.println(s);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {

             final String DRIVER_CLASS = "www.com";
            Class.forName(DRIVER_CLASS);

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {

            Hashtable hmap = new Hashtable();
            Enumeration enumer = hmap.elements();
            enumer.nextElement();

        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
