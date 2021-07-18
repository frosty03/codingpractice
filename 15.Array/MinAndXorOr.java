
/**
 Problem Statement: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/minimum-and-xor-or-6a05bbd4/
 Submitted Solution: https://www.hackerearth.com/submission/60635579/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MinAndXorOr {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        new MinAndXorOr().runner();
    }

    private void runner() {
        int t = nextInt();

        while( t --> 0 ) {
            int n = nextInt();

            int arr[] = new int[n];

            for(int i=0; i<n; i++) {
                arr[i] = nextInt();
            }

            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            for(int i=0; i<n-1; i++) {
                min = Math.min(min, arr[i]^arr[i+1]);
            }
            pw.println(min);
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

