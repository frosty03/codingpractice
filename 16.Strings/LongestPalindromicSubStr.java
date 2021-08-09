
/**
 Problem Statement: https://leetcode.com/problems/longest-palindromic-substring/
 Submitted Solution: https://leetcode.com/submissions/detail/535927550/

 Given a string s, return the longest palindromic substring in s.

 Example 1:

 Input: s = "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongestPalindromicSubStr {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);


    public String longestPalindrome(String s) {
        if (s.length()==1) return s;
        int a,b;
        int max=1, maxa=0, maxb=0;
        for (int i=0; i<s.length()-1; i++) {
            // for even
            b=i;
            a=i+1;
            while(a>0 && b<s.length()-1 && s.charAt(a-1) == s.charAt(b+1)) {
                a--; b++;
            }
            if(a>=0 && b<s.length() && b-a+1>max) {
                max=b-a+1;
                maxa=a;
                maxb=b;
            }

            // for odd
            a=b=i;
            while(a>0 && b<s.length()-1 && s.charAt(a-1) == s.charAt(b+1)) {
                a--; b++;
            }
            if(a>=0 && b<s.length() && b-a+1>max) {
                max=b-a+1;
                maxa=a;
                maxb=b;
            }
        }
        return s.substring(maxa, maxb+1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("a"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("ab"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("aa"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("aaa"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("baabad"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("baabadbadab"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("baabadbaddab"));
        System.out.println(new LongestPalindromicSubStr().longestPalindrome("cbbd"));
    }
}
