package com.example.stub.dp;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/common-child
 * Submitted Solution: https://www.hackerrank.com/challenges/common-child/submissions/code/240429516
 *
 * Longest common subsequence problem
 */

import java.io.IOException;

public class CommonChild {

        /*
         * Complete the 'commonChild' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING s1
         *  2. STRING s2
         */
        public static int commonChild(String s1, String s2) {
            int l[][] = new int[s1.length()+1][s2.length()+1];
            for(int i=s1.length()-1; i>=0; i--) {
                for(int j=s2.length()-1; j>=0; j--) {
                    if(s1.charAt(i) == s2.charAt(j)) {
                        l[i][j] = l[i+1][j+1]+1;
                    }
                    else {
                        l[i][j] = Math.max(l[i+1][j],
                                l[i][j+1]);
                    }
                }
            }
            return l[0][0];
        }
}

class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("3:" + CommonChild.commonChild("ABCD", "ABDC"));
        System.out.println("2:" + CommonChild.commonChild("HARRY", "SALLY"));
        System.out.println("0:" + CommonChild.commonChild("AA", "BB"));
        System.out.println("3:" + CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
        System.out.println("2:" + CommonChild.commonChild("ABCDEF", "FBDAMN"));

        System.out.println("3:" + CommonChild.commonChild("RAMANI", "SAHASI"));
        System.out.println("2:" + CommonChild.commonChild("ASHA", "HAZS"));
        System.out.println("3:" + CommonChild.commonChild("ASHAZ", "HAZS"));
        System.out.println("3:" + CommonChild.commonChild("ASHA", "HAZSH"));
        System.out.println("2:" + CommonChild.commonChild("DEFXZ", "ABCDZ"));
    }
}

