
/**
 Problem statement: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/the-code-generator-9d3f9afa/
 Submitted Solution: https://www.hackerearth.com/submission/60634202/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KthBinaryNumber {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final int fibo[] = populateFibo();

    public static void main(String[] args) {
        new KthBinaryNumber().runner();
    }

    private static int[] populateFibo() {
        int t[] = new int[41];

        t[0]=1;
        t[1]=2;

        for(int i=2; i<41; i++) {
            t[i]=t[i-1]+t[i-2];
        }
        return t;
    }

    private String findN(int N) {
        int f=0;
        String s = "";
        for(int i=39;i>=0;i--) {
            if (fibo[i] <= N) {
                f = 1;
                s = s + "1";
                N = N - fibo[i];
                continue;
            }

            if (f == 1)
                s = s + "0";
        }
        return s;
    }

    private void runner() {
        int t = nextInt();

        while (t --> 0) {
            pw.println(findN(nextInt()));
        }
        pw.flush();
    }

    static int nextInt() {
        int read = 0, num=0;
        try {
            while(read < '0' || read > '9') read=br.read();
            while(read >= '0') {
                num = num*10 + read-'0';
                read=br.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}

