package com.example.stub.string;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/special-palindrome-again/problem
 * Submitted Solution: https://www.hackerrank.com/challenges/special-palindrome-again/submissions/code/239733211
 *
 * A string is said to be a special string if either of two conditions is met:
 *
 * All of the characters are the same, e.g. aaa.
 * All characters except the middle one are the same, e.g. aadaa.
 * A special substring is any substring of a string which meets one of those criteria. Given a string, determine
 * how many special substrings can be formed from it.
 *
 */

import java.io.IOException;
import java.util.Scanner;

public class SpecialPalindrome {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int count=0;
        char c[] = s.toCharArray();
        for(int i=0; i<n; i++) {
            // increment for individual letter
            count++;

            // increment for same words
            for(int j=i+1; j<n && c[i]==c[j]; j++, count++);

            // increment for words with different middle
            // but everything else same
            for(int j=i+1, k=i-1; k>=0 && j<n && c[j]==c[k]&&c[k]==c[i+1]&&c[i]!=c[i+1]; j++, k--, count++);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("7:" + substrCount(5, "asasd"));
        System.out.println("10:" + substrCount(7, "abcbaba"));
        System.out.println("10:" + substrCount(4, "aaaa"));
        System.out.println("1:" + substrCount(1, "a"));
        System.out.println("2:" + substrCount(2, "ab"));
    }
}
