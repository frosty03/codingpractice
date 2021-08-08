package com.example.stub.array;

/**
Problem Statement: https://leetcode.com/problems/largest-number/
Submitted Solution: https://leetcode.com/submissions/detail/535319901/

 Given a list of non-negative integers nums, arrange them such that they form the largest number.
 Note: The result may be very large, so you need to return a string instead of an integer.

 Example 1:

 Input: nums = [10,2]
 Output: "210"
 Example 2:

 Input: nums = [3,30,34,5,9]
 Output: "9534330"
 Example 3:

 Input: nums = [1]
 Output: "1"
 Example 4:

 Input: nums = [10]
 Output: "10"
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        new LargestNumber().runner();
        pw.flush();
    }

    private void runner() {
        pw.println(largestNumber(new int[]{1, 34, 3, 98, 9, 76, 45, 4}));
    }

    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();

                java.math.BigInteger s12 = new java.math.BigInteger(s1.concat(s2));
                java.math.BigInteger s21 = new java.math.BigInteger(s2.concat(s1));
                return s21.compareTo(s12);
            }
        });
        String s = list.stream().map(Object::toString).collect(Collectors.joining(""));
        return s.replaceAll("^0+", "0");
    }
}

