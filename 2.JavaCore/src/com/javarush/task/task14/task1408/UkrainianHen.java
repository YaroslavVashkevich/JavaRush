package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }
    @Override
    String getDescription(){
        return new Hen() {
            @Override
            int getCountOfEggsPerMonth() {
                return 0;
            }
        }.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
