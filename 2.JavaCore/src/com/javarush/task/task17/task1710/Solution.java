package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        if (args[0].equals("-c")) {
            c(args[1], args[2], args[3]);
        } else if (args[0].equals("-r")) {
            r(args[1]);
        } else if (args[0].equals("-u")) {
            u(args[1], args[2], args[3], args[4]);
        } else if (args[0].equals("-d")) {
            d(args[1]);
        }
    }

    public static void c(String name, String sex, String bd) {
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

    public static void r(String id) {
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

    public static void u(String id, String name, String sex, String bd) {
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

    public static void d(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }
}
