package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() {
        return 50;
    }

    @Override
    String getDescription(){
        return new Hen() {
            @Override
            int getCountOfEggsPerMonth() {
                return 0;
            }
        }.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
