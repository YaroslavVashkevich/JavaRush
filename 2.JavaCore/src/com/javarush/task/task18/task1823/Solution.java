package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        while (!source.equals("exit")) {
            ReadThread readThread = new ReadThread(source);
            readThread.start();
            source = sc.nextLine();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run() {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> hashMap = new LinkedHashMap<>();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                while (fileInputStream.available() > 0) {
                    Integer key = fileInputStream.read();
                    Integer value = hashMap.get(key);
                    hashMap.put(key,value == null ? 1 : value + 1);
                }
                int max = 0;
                Integer keyMax = null;
                for (Map.Entry<Integer, Integer> tmp : hashMap.entrySet()) {
                    if (tmp.getValue() > max) {
                        max = tmp.getValue();
                        keyMax = tmp.getKey();
                    }
                }
                int valueMaxKey = hashMap.get(keyMax);
                for (Map.Entry<Integer, Integer> tmp : hashMap.entrySet()) {
                    if (tmp.getValue() == valueMaxKey) {
                        list.add(tmp.getKey());
                    }
                }
                resultMap.put(this.fileName, Collections.min(list));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
