
/**
 * Problem Statement: https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/travelling-tom-7eadedb7/
 * Submitted Solution: https://www.hackerearth.com/submission/60409713/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TravelingTom {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static int n;

    class Adj implements Comparable<Adj> { public int c, a, wt;
        public Adj(int c) {
            this.c = c;
        }

        public Adj(int c, int a, int wt) {
            this.c = c;
            this.a = a;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Adj{" +
                    "c=" + c +
                    ", a=" + a +
                    ", wt=" + wt +
                    '}';
        }

        @Override
        public int compareTo(Adj o) {
            return new Integer(this.c).compareTo(o.c);
        }

        @Override
        public boolean equals(Object oc) {
            int c = (int) oc;
            return this.c == c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    public static void main(String[] args) {
        n=nextInt();
        new TravelingTom().runner();
    }

    LinkedList<Adj> adj = new LinkedList<>();
    public void runner() {
        int m=nextInt(), k=nextInt();
        long cost[] = new long[k];
        int [][] l  = new int[m][];
        int [] bitwiseCost = new int[m];
        boolean visited[];

        for ( int i=0; i<k; i++ ) {
            cost[i] = nextLong();
        }
        for(int i=0; i<m; i++) {
            int c1 = nextInt();
            int c2 = nextInt();

            int ln = nextInt();
            int temp[] = new int[ln];

            int bitwiseCostTemp = 0;
            for (int j=0; j<ln; j++) {
                temp[j] = nextInt();

                bitwiseCostTemp |= 1<<temp[j]-1;
            }
            l[i] = temp;
            bitwiseCost[i] = bitwiseCostTemp;

            adj.add(new Adj(c1, c2, bitwiseCost[i]));
            adj.add(new Adj(c2, c1, bitwiseCost[i]));
        }
        Collections.sort(adj);
        int allBitwise = (1 << k)-1;
        for(int i=k; i>=1; i--) {
            visited = new boolean[n];
            int thisBit = 1<<i-1;
            int withoutI = allBitwise ^ thisBit;
            if(isItPossible(visited, withoutI)) {
                allBitwise = withoutI;
            }
        }

        long totalCost = 0;
        char[] fina = Integer.toBinaryString(allBitwise).toCharArray();
        for(int i=0; i<fina.length; i++) {
            if(fina[i]=='1') {
                totalCost+=cost[fina.length-i-1];
            }
        }
        pw.println(totalCost);
        pw.flush();
    }

    public boolean isItPossible(boolean visited[], int withThisBitwise) {
        if(allVisited(visited)) return true;
        Stack<Integer> dfsNodes = new Stack<>();
        dfsNodes.push(1);
        while (!allVisited(visited) && !dfsNodes.isEmpty()) {
            Integer traversingThis = dfsNodes.pop();
            List<Adj> adjSublist = getAdj(traversingThis);
            for(Adj a : adjSublist) {
                if(!visited[a.a-1] && (withThisBitwise | a.wt) == withThisBitwise) {
                    dfsNodes.add(a.a);
                }
            }
            visited[traversingThis-1]=true;
        }
        return allVisited(visited);
    }

    private List<Adj> getAdj(int c) {
        int i,j;
        i = j = Collections.binarySearch(adj, new Adj(c));
        while(i>=0 && adj.get(i).equals(c)) i--;
        while(j<adj.size() && adj.get(j).equals(c)) j++;
        return adj.subList(i+1, j);
    }

    private static boolean allVisited(boolean[] visited) {
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;
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

    static long nextLong() {
        long read = 0, num=0;
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
