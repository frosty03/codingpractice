package com.example.stub.string;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/sherlock-and-valid-string/
 * Code Submission: https://www.hackerrank.com/challenges/sherlock-and-valid-string/submissions/code/239721255
 *
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters
 * will occur the same number of times. Given a string s, determine if it is valid. If so, return YES, otherwise
 * return NO.
 *
 * Sample Input 0
 * aabbcd
 *
 * Sample Output 0
 * NO
 *
 * Sample Input 2
 * abcdefghhgfedecba
 *
 * Sample Output 2
 * YES
 */

import java.io.IOException;
import java.io.PrintWriter;


public class SherlockValidString {


    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        boolean oneReplacementFlag=false;
        int n1=-1,n2=-1;
        int countOnes=0;

        int charCount[] = new int[26];
        for(char c: s.toCharArray()) {
            charCount[c-'a']++;
        }

        for(int i=0; i< charCount.length; i++) {
            if (charCount[i] == 0) continue;
            if (charCount[i] == 1) countOnes++;
            if (n1 == -1) {
                n1 = charCount[i];
                continue;
            }
            if(n1 == charCount[i]) {
                oneReplacementFlag = true;
                continue;
            }
            if (n2 == -1) {
                n2 = charCount[i];
                if(countOnes==1 && n2==1) continue;
                if(!(Math.abs(n2-n1)==1)) {
                    return "NO";
                }
                continue;
            }
            if(n2 == charCount[i] && !oneReplacementFlag) {
                oneReplacementFlag = true;
                continue;
            }
            return "NO";
        }

        if(Math.abs(n2-n1)!=1 && n2!=-1&&countOnes>1) {
            return "NO";
        }
        return "YES";
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);

        System.out.println("\nShould return Yes");
        System.out.println(SherlockValidString.isValid(""));;
        System.out.println(SherlockValidString.isValid("a"));;
        System.out.println(SherlockValidString.isValid("ab"));;
        System.out.println(SherlockValidString.isValid("aab"));;
        System.out.println(SherlockValidString.isValid("abb"));;
        System.out.println(SherlockValidString.isValid("abc"));;
        System.out.println(SherlockValidString.isValid("abcc"));;
        System.out.println(SherlockValidString.isValid("abcdefghhgfedecba"));;
        System.out.println(SherlockValidString.isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));;

        System.out.println("\nShould return No");
        System.out.println(SherlockValidString.isValid("abccdd"));;
        System.out.println(SherlockValidString.isValid("aabbcd"));;
        System.out.println(SherlockValidString.isValid("aabbccddeefghi"));;
        System.out.println(SherlockValidString.isValid("aaaaabc"));
        System.out.println(SherlockValidString.isValid("aaaabbcc"));
    }
}
