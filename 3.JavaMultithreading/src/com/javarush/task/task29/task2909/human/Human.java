package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size;

    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


    public class Size{

        public int height;
        public int weight;

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {
    }

    public int getId() {
        return id;
    }

    public List<Human> getChildren() {
        List<Human> immutablelist = Collections.unmodifiableList(children);
        return immutablelist;
    }

    public void addChild (Human child){
        if(child!=null) {
            children.add(child);
        }
    }

    public void removeChild (Human child){
        children.remove(child);
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
}