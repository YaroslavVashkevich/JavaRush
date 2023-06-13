package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        solutions[0] = solution1;
        solutions[1] = solution2;
        solutions[0].innerClasses[0] = new Solution().new InnerClass();
        solutions[0].innerClasses[1] = new Solution().new InnerClass();
        solutions[1].innerClasses[0] = new Solution().new InnerClass();
        solutions[1].innerClasses[1] = new Solution().new InnerClass();

        return solutions;
    }

    public static void main(String[] args) {

    }
}
