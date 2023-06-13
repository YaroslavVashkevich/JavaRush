package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int count = 1;
        try {
            while (true){

            map.put(Integer.toString(count), "Some text for " + count);
                Thread.sleep(500);
            count++;}
        } catch (InterruptedException e) {
            System.out.println("[" + currentThread.getName() + "]" + " thread was terminated");
        }



    }
}
