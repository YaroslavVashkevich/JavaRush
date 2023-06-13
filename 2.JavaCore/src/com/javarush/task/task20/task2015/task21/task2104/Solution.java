package com.javarush.task.task20.task2015.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n)
            return true;
        if (n == null)
            return false;
        if (!(n instanceof Solution))
            return false;
        Solution solution = (Solution) n;
        if (!Objects.equals(first, solution.first)) return false;
        return Objects.equals(last, solution.last);
    }

    public int hashCode() {
        int result = first == null ? 0 : first.hashCode();
        result = 31 * result + (last == null ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
