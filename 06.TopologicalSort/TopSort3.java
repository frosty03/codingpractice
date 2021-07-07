
/**
 * Problem Statement: https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/topological-sorttutorial/
 * Submitted Solution: https://www.hackerearth.com/submission/59796855/


 ********************************************
 *********** PROBLEM STATEMENT  *************
 ********************************************


 * Problem
 * Given a Directed and Acyclic Graph having N vertices and M edges, print topological sorting of the vertices.
 *
 * Input:
 * First line consists of two space separated integers denoting N and M.
 * Each of the following M lines consists of two space separated integers X and Y denoting there is an from X directed towards Y.
 *
 * Output:
 * Print N space separated integers denoting the topological sort, if there are multiple ordering print the lexicographically smallest one.
 *
 * Sample Input
 * 5 6
 * 1 2
 * 1 3
 * 2 3
 * 2 4
 * 3 4
 * 3 5
 * Sample Output
 * 1 2 3 4 5
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TopSort3 {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);
    private List<Integer[]> topo = new ArrayList<>();
    private static int N,M;

    public static void main(String[] args) throws IOException {
        new TopSort3().solver();
    }

    private void solver() throws IOException {
        int NM[] = nextIntArr();
        N=NM[0]; M=NM[1];
        int degree[] = new int[NM[0]];
        int adj[][] = new int[NM[1]][2];
        Stack<Integer> queue = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        for ( int i=0; i<NM[1]; i++ ) {
            adj[i] = nextIntArr();
            adj[i][0]--; adj[i][1]--;
            degree[adj[i][1]]++;
        }

        populateQueue(degree, queue, stack, -1);

        while( ! queue.isEmpty() ) {
            Integer poll = queue.pop();

            if (!stack.contains(poll)) {
                stack.push(poll);
            }

            Arrays.stream(adj)
                    .filter(ints -> ints[0] == poll)
                    .filter(ints -> ! stack.contains(ints[1]))
                    .forEach(ints -> {
                        --degree[ints[1]];
                    });

            populateQueue(degree, queue, stack, poll);
        }

        for (Integer i: stack) {
            pw.print((i+1) + " ");
        }
        pw.flush();
    }

    private void populateQueue(int[] degree, Stack<Integer> queue, Stack<Integer> stack, int curr) {
        for(int i = degree.length-1; i>=0; i--) {
            if ( degree[i] == 0 && ! stack.contains(i)&& ! queue.contains(i) && i != curr) {
                queue.add(i);
            }
        }
    }

    public int[] nextIntArr() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
