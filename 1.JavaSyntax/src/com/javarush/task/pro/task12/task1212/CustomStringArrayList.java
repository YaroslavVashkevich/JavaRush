package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        capacity *= 1.5;
        String[] elementsNew = new String[capacity];
        int i = 0;
        for (String element:elements) {
            elementsNew[i] = element;
            i++;
        }
        elements = elementsNew;
    }

}