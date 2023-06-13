package com.javarush.task.task14.task1420;


import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int nod = nod(a, b);
        System.out.println(nod);
    }
    public static int nod(int a, int b) {
        for (int i = (a > b ? b : a); i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
