
/**
 * Problem Statement: https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/binary-palindrome-4-035e5ad6/
 * Submitted Solution: https://www.hackerearth.com/submission/60344301/
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class BinaryPalindrome {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final int N = nextInt();
    private static int palindromes[] = new int[98304];
    private static int pindex=0;

    public static void main(String[] args) {
        new BinaryPalindrome().printAll("0", 16);
        Arrays.sort(palindromes);

        for(int i=0; i<N; i++) {
            pw.println(solver(nextInt()));
        }
        pw.flush();
    }

    public void printAll(String parent, int n) {
        if(n==1) {
            String processed = parent.replaceAll("(^0+)(.*)", "$2");
            String f1 = processed + "1" + new StringBuilder(processed).reverse();
            String f2 = processed + "0" + new StringBuilder(processed).reverse();
            String f3 = processed + new StringBuilder(processed).reverse();
            palindromes[pindex++] = Integer.parseInt(f1, 2);
            palindromes[pindex++] = Integer.parseInt(f2, 2);
            try {
                palindromes[pindex++] = Integer.parseInt(f3, 2);
            }
            catch (NumberFormatException e ) {} // consume
            return;
        }

        printAll(parent + "0", n-1);
        printAll(parent + "1", n-1);
    }

    private static int solver(int n) {
        int i = Arrays.binarySearch(palindromes, n);
        if(i>=0) return 0;

        i=(i*-1)-1;
        return Math.min(Math.abs(n-palindromes[i]), Math.abs(n-palindromes[i-1]));
    }

    private static final int nextInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

