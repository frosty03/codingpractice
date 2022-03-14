package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://practice.geeksforgeeks.org/problems/edit-distance3702/1/#
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=eb199cfd9e5e857de26f46be1e049a25&pid=703912&user=frosty03
 *
 * Edit Distance
 *
 Input:
 s = "geek", t = "gesek"
 Output: 1
 Explanation: One operation is required
 inserting 's' between two 'e's of str1.
 *
 */

public class EditDistance {
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int editDistance(String s, String t) {
        int m[][] = new int[s.length()+1][t.length()+1];

        for (int i=0; i<=s.length(); i++) {
            for (int j=0; j<=t.length(); j++) {
                if(i==0 || j==0) {
                    m[i][j]=i+j;
                }
                else if(s.charAt(i-1)==t.charAt(j-1)) {
                    m[i][j]=m[i-1][j-1];
                }
                else {
                    int dp = 1+min(m[i-1][j-1], m[i-1][j], m[i][j-1]);
                    m[i][j] = dp;
                }
            }
        }
        return m[s.length()][t.length()];
    }

    public static void main(String[] args) {
//        System.out.println("1: " + new EditDistance().editDistance("k", "k"));
//        System.out.println("1: " + new EditDistance().editDistance("k", "s"));

//        System.out.println("5: " + new EditDistance().editDistance("AGRAM", "ARAAMNGRAM"));
        System.out.println("1: " + new EditDistance().editDistance("geek", "gesek"));
//        System.out.println("0: " + new EditDistance().editDistance("gfg", "gfg"));
//        System.out.println("3: " + new EditDistance().editDistance("gfg", "def"));
//
//        System.out.println("3: " + new EditDistance().editDistance("gfg", "defgfg"));
        System.out.println("9: " + new EditDistance().editDistance("ecfbefdcfca", "badfcbebbf"));
    }
}
