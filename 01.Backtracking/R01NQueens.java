

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 * Problem statement: https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/n-queensrecursion-tutorial/
 *
 * Submission is available here: https://www.hackerearth.com/submission/59601219/
 */

public class R01NQueens {
    private static final BufferedReader br;
    private static final PrintWriter pw;
    private static final int N;

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        N = nextInt();
    }

    public static void main(String args[] ) throws Exception {
        new NQueens().runner();
    }

    public void runner() {
        int[][] queens = new int[N][2];
        boolean queenPos = getQueenPos(queens, 0, 0, N);
        printMatrix(queenPos, queens);
        pw.flush();
    }

    private void printMatrix(boolean queenPos, int [][] q) {
        if(!queenPos) {
            pw.println("Not possible");
            return;
        }

        int[][] queens = new int[N][N];

        for(int i=0; i<N; i++) {
            if(i!=0 && (q[i][0]==0 && q[i][1]==0) ) continue;
            queens[q[i][0]][q[i][1]]=1;
        }

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                pw.print(queens[i][j] + " ");
            }
            pw.println();
        }
    }

    private boolean getQueenPos(int [][] q, int i, int jj, int nq) {
        nq--;
        for(int j=0; j<N; j++) {
            int[] next = next(q, i, j, N-nq-1);
            if(next == null) {
                q[N-nq-1][0]=0;
                q[N-nq-1][1]=0;
                return false;
            }
            i=next[0];
            j=next[1];
            q[N-nq-1][0]=i;
            q[N-nq-1][1]=j;
            if(nq==0) {
                return true;
            }
            int newj = j+1>=N?0:j+1;
            if(getQueenPos(q, i+1, newj, nq)) {
                return true;
            }
        }
        return false;
    }

    private static int nextInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Didn't got integer input");
        }
    }

    public int[] next(int q[][], int ii, int jj, int nq) {
        for(int i=ii; i<N; i++) {
            for(int j=jj; j<N; j++) {
                if(isSafe(q, i, j, nq)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean isSafe(int q[][], int ii, int jj, int nq) {
        for ( int i=0; i<nq; i++) {
            if( (q[i][0]==ii || q[i][1]==jj)
            || (Math.abs(q[i][0]-ii) == Math.abs(q[i][1]-jj)  ) ) {
                return false;
            }
        }
        return true;
    }
}
