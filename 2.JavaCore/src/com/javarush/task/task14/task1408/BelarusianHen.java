package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 100;
    }
    @Override
    String getDescription(){
        return new Hen() {
            @Override
            int getCountOfEggsPerMonth() {
                return 0;
            }
        }.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
