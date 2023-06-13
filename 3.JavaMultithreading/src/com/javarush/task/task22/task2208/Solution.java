package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", null);
        params.put("country", null);
        params.put("city", null);
        params.put("age", null);
        System.out.println(getQuery(params));

    }

    public static String getQuery(Map<String, String> params) {
        int count = 0;
        if (params.isEmpty()){
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> tmp : params.entrySet()) {
                if (tmp.getValue() != null) {
                    sb.append(tmp.getKey()).append(" = '").append(tmp.getValue()).append("' and ");
                    count++;
                }
            }
            if (count > 0) {
                sb.delete(sb.length() - 5, sb.length());
                return sb.toString();
            }else {
                return "";
            }

        }
    }
}
