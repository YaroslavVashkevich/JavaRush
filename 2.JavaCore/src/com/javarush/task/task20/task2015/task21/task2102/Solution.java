package com.javarush.task.task20.task2015.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        if (Modifier.isPrivate(allModifiers) && specificModifier == Modifier.PRIVATE) {
            return true; }
        if (Modifier.isStatic(allModifiers)&& specificModifier == Modifier.STATIC) {
            return true; }
        if (Modifier.isFinal(allModifiers)&& specificModifier == Modifier.FINAL) {
            return true;}
        if (Modifier.isProtected(allModifiers) && specificModifier == Modifier.PROTECTED) {
            return true; }
        if (Modifier.isPublic(allModifiers) && specificModifier == Modifier.PUBLIC ) {
            return true; }
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
