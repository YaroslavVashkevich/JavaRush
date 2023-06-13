package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
            String[] array = loadWheelNamesFromDB();
            Wheel[] wh = Wheel.values();
            int count = 0;
            for (Wheel wheel : wh){
                for (int i = 0; i < array.length; i++) {
                    if (wheel.toString().equals(array[i])){
                        wheels.add(wheel);
                        count++;
                    }
                }
            }
            if (count != wh.length){
                throw new RuntimeException();
            }


        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Solution.Car s = new Solution.Car();
        System.out.println(s.wheels);


    }
}
