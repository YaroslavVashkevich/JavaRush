package com.javarush.task.pro.task06.task0607;

/* 
Добро пожаловать! Но не всем.
*/

public class Solution {

    public static void main(String[] args) {
        signIn("user1");
    }

    public static void signIn(String username) {
        //напишите тут ваш код
        if (username != "user") {
            System.out.println("Добро пожаловать " + username);
            System.out.println("Очень скучали по Вам, " + username);
        } else {
            return;
        }

    }
}
