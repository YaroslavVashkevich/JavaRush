package com.javarush.task.task20.task2025;

import java.util.*;


/* 
Алгоритмы-числа
*/

public class Solution {
    private static int depth;
    private static int[] digits;
    private static List<Long> resultList;
    public static long[] getNumbers(long N) {

        int digit = digit(N);
        if (digit > 0) {
            digits = new int[digit];
            long[][] pows = arrayPow(N);
            resultList = new ArrayList<>();

            for (depth = 0; depth < digit; depth++) {
                capacityIteration(0, depth, N, pows);
            }
        }
        Collections.sort(resultList);
        return Arrays.stream(resultList.toArray(new Long[0])).mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    public static int digit(long x) {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }
        return count;
    }

    public static long pow(long value, long powValue) {
        long result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
    public static long[][] arrayPow(long N) {
        long[][] array = new long[10][digit(N)];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = pow(i, j + 1);
            }
        }
        return array;
    }
    public static void capacityIteration(int start, int capacity, long N, long[][] pows) {

        for (start = start == 0 && capacity == 0 ? 1 : start; start <= 9; start++) {
            digits[capacity] = start;

            if (capacity > 0) {
                capacityIteration(start, capacity - 1, N, pows);
            } else {
                long sumPows = 0;

                for (int i = 0; i <= depth; i++) {
                    sumPows += pows[digits[i]][depth];
                }

                char[] chars = String.valueOf(sumPows).toCharArray();

                if (chars.length - 1 == depth && sumPows < N) {
                    firstBlock:
                    {
                        for (int i = 0; i <= depth; ++i) {
                            secondBlock:
                            {
                                for (int j = 0; j < chars.length; j++) {
                                    if (digits[i] + 48 == chars[j]) {
                                        chars[j] = 0;
                                        break secondBlock;
                                    }
                                }
                                break firstBlock;
                            }
                        }
                        resultList.add(sumPows);
                    }
                }
            }
        }
    }

}
