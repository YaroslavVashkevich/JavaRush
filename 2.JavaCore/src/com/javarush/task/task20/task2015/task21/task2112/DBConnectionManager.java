package com.javarush.task.task20.task2015.task21.task2112;

public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
