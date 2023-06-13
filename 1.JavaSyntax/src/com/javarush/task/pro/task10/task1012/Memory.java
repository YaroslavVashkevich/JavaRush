package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

//    public static void executeDefragmentation(String[] memory) {
//        //напишите тут ваш код
//        int arrayLength = memory.length;
//        int i1 = 0;
//        for (int i = 0; i < arrayLength; i++) {
//            if (memory [i] != null) {
//                memory [i1] = memory [i];
//                if (i1 != i) memory [i] = null;
//                i1++;
//            }
//        }
//
//    }
public static void executeDefragmentation(String[] array) {
    //напишите тут ваш код
    int count = 0;
    String[] memoryNew = new String[array.length];
    for (int i = 0; i < array.length; i++) {
        if (array[i] != null){
            memoryNew[count] = array[i];
            count++;
        }else {
            memoryNew[(memoryNew.length - 1) - count] = array[i];
        }
    }
    for (int i = 0; i < array.length; i++) {
        array[i] = memoryNew[i];
    }
}
}
