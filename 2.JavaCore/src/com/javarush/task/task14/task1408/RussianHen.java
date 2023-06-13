package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 150;
    }
    @Override
    String getDescription(){
        return new Hen() {
            @Override
            int getCountOfEggsPerMonth() {
                return 0;
            }
        }.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
