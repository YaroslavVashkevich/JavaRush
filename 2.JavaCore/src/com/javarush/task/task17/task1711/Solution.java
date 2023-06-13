package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    c(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    i(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    u(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    d(args);
                }
        }
    }

    public static void c(String[] args) {
        String[] argsId = new String[args.length - 1];
        for (int i = 0; i < argsId.length; i++) {
            argsId[i] = args[i + 1];
        }
        for (int i = 0; i < argsId.length / 3; i++) {
            c1(argsId[i * 3], argsId[i * 3 + 1], argsId[i * 3 + 2]);
        }
    }

    public static void i(String[] args) {
        String[] argsId = new String[args.length - 1];
        for (int i = 0; i < argsId.length; i++) {
            argsId[i] = args[i + 1];
        }
        for (String id : argsId) {
            Person person = allPeople.get(Integer.parseInt(id));
            String sex = "";
            Date date = person.getBirthDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
            String bdPerson = formatter.format(date);

            if (person.getSex() == Sex.MALE) {
                sex = "м";
            } else if (person.getSex() == Sex.FEMALE) {
                sex = "ж";
            }
            System.out.println(person.getName() + " " + sex + " " + bdPerson);
        }
    }

    public static void u(String[] args) {
        String[] argsId = new String[args.length - 1];
        for (int i = 0; i < argsId.length; i++) {
            argsId[i] = args[i + 1];
        }
        for (int i = 0; i < argsId.length / 4; i++) {
            u1(argsId[i * 4], argsId[i * 4 + 1], argsId[i * 4 + 2], argsId[i * 4 + 3]);
        }
    }

    public static void d(String[] args) {
        String[] argsId = new String[args.length - 1];
        for (int i = 0; i < argsId.length; i++) {
            argsId[i] = args[i + 1];
        }
        for (String id : argsId) {
            Person person = allPeople.get(Integer.parseInt(id));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
    public static void c1(String name, String sex, String bd) {
        Person person = null;
        String[] bdPerson = bd.split("/");
        Date date = new Date((Integer.parseInt(bdPerson[2]) - 1900), (Integer.parseInt(bdPerson[1]) - 1), Integer.parseInt(bdPerson[0]));
        if (sex.equals("м")) {
            person = Person.createMale(name, date);
        } else if (sex.equals("ж")) {
            person = Person.createFemale(name, date);
        }
        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }
    public static void u1(String id, String name, String sex, String bd) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        if (sex.equals("м")) {
            person.setSex(Sex.MALE);
        } else if (sex.equals("ж")) {
            person.setSex(Sex.FEMALE);
        }
        String[] bdPerson = bd.split("/");
        Date date = new Date((Integer.parseInt(bdPerson[2]) - 1900), (Integer.parseInt(bdPerson[1]) - 1), Integer.parseInt(bdPerson[0]));
        person.setBirthDate(date);
    }

}
