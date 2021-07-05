
 * Problem Statement: https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/divide-number-a410603f/
 * Submitted Solution: https://www.hackerearth.com/submission/59663459/
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class DivideNumber {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);
    private TreeSet<Integer> factors;
    private static final int factors15[] = {2,3,4,5,6,7,8,9,10,12,15,18,20,24,42};


    public static void main(String[] args) throws IOException {
        new DivideNumber().solver();
    }

    private void solver() throws IOException {
        int T = nextInt();

        while ( T --> 0) {
            int N = nextInt();
            factors = getFactors(N);
            pw.println(findSol(N, 4));
        }
        pw.flush();
    }

    public TreeSet<Integer> getFactors(int N) {
        TreeSet<Integer> factors = new TreeSet<Integer>();
        factors.add(1);
        for(int i=0; i<factors15.length; i++) {
            if(N%factors15[i]==0) {
                factors.add(N/factors15[i]);
            }
        }
        return factors;
    }

    public long findSol(int N, int count) {
        long max = Long.MIN_VALUE;
        if(count == 1)
            return factors.contains(N) ? N : -1;

        for(Integer t : factors) {
            long product = t * findSol(N - t, count - 1);
            max = Math.max(max, product);
        }
        return max;
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

}

