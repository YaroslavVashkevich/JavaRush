package com.javarush.task.task20.task2002;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", ".txt", new File("g:\\folder"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new Date(89, 2, 21));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Anna");
            user2.setLastName("Petrova");
            user2.setBirthDate(new Date(105, 9, 15));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (!users.isEmpty()) {
            try (PrintWriter pw = new PrintWriter(outputStream)) {
                    for (User u : users) {
                        pw.print(u.getFirstName());
                        pw.print(" ");
                        pw.print(u.getLastName());
                        pw.print(" ");
                        pw.print(u.getBirthDate().getTime());
                        pw.print(" ");
                        pw.print(u.isMale());
                        pw.print(" ");
                        pw.println(u.getCountry().getDisplayName());
                    }
            }
        }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                while (br.ready()) {
                    String[] str = br.readLine().split(" ");
                    User user = new User();
                    user.setFirstName(str[0]);
                    user.setLastName(str[1]);
                    user.setBirthDate(new Date(Long.parseLong(str[2])));
                    user.setMale(Boolean.parseBoolean(str[3]));
                    user.setCountry(User.Country.valueOf(str[4].toUpperCase()));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
