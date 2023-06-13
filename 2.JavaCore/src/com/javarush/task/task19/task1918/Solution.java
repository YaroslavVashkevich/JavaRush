package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String file = "";
        String result = "";
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            file = bufferedReader.readLine();
        }
        try (FileReader fileReader = new FileReader(file)) {
            while (fileReader.ready()) {
                result += (char)fileReader.read();
            }
        }
        Document document = Jsoup.parse(result, "", Parser.xmlParser());
        Elements elem = document.select(args[0]);
        for (Element elements : elem){
            System.out.println(elements);
        }

    }
}
