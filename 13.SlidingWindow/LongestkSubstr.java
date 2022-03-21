package com.example.stub.unassigned;

/**
 * Problem statement: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 * Submitted solution: https://practice.geeksforgeeks.org/viewSol.php?subId=8744cfb7f611e4e6f76ef3d17c9d791c&pid=703219&user=frosty03
 *
 Input:
 S = "aabacbebebe", K = 3
 Output: 7
 Explanation: "cbebebe" is the longest
 substring with K distinct characters.

 tag: sliding window
 */

public class LongestkSubstr {
    public int longestkSubstr(String s, int k) {
        boolean c[] = new boolean[26];
        int cn = 0;
        int li=0, ri=0, max=-1;
        c[s.charAt(0)-'a']=true;
        cn++;

        while (ri<s.length()) {
            while(cn < k) {
                if(ri>=s.length()) return -1;
                if(!c[s.charAt(ri)-'a']) {
                    c[s.charAt(ri)-'a'] = true;
                    cn++;
                }
                ri++;
            }
            ri--;
            while( ri<s.length()-1 && c[s.charAt(ri+1)-'a'] ) ri++;
            String temp = s.substring(li, ri+1);
            max = Math.max(max, ri-li+1);
            if(ri==s.length()-1) break;
            char fc = s.charAt(li);
            while(s.charAt(li) == fc) li++;
            c = new boolean[26];
            cn=0;
            ri=li;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestkSubstr l = new LongestkSubstr();
        System.out.println("7:" + l.longestkSubstr("aabacbebebez", 3));

        System.out.println("3:" + l.longestkSubstr("abc", 3));
        System.out.println("6:" + l.longestkSubstr("abcabc", 3));
        System.out.println("6:" + l.longestkSubstr("aabbcc", 3));
        System.out.println("-1:" + l.longestkSubstr("aaaa", 2));

        System.out.println("2:" + l.longestkSubstr("aabbcc", 1));
        System.out.println("4:" + l.longestkSubstr("aabbcc", 2));
        System.out.println("6:" + l.longestkSubstr("aabbcc", 3));
        System.out.println("-1:" + l.longestkSubstr("aaabbb", 3));

        System.out.println("1:" + l.longestkSubstr("a", 1));
        System.out.println("2:" + l.longestkSubstr("aa", 1));
        System.out.println("-1:" + l.longestkSubstr("a", 2));
        System.out.println("9:" + l.longestkSubstr("wcysyycqpev", 6));
        System.out.println("9:" + l.longestkSubstr("ujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafs", 4));
    }
}
