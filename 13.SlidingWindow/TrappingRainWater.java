
/**
 Problem Statement: https://www.codechef.com/problems/CRES102
 Codechef Submission: https://www.codechef.com/viewsolution/48504733



 ********************************************
 *********** PROBLEM STATEMENT  *************
 ********************************************


 Sai Charan is a professional programmer such that whatever he finds interesting, he would
 immediately convert it into a problem and try to get an algorithm for it which is the stepping
 stone for solving a problem. He saw water stagnation infront of his house after a heavy rain.
 So, he got an idea to write a program to find the amount of water stagnated, which is the
 inspiration for this problem

 Problem Description


 You are given an iron bar which is of dimension 1 unit. Iron bars are placed in a particular
 format for each test case, You must display the maximum units of accumulation of water between
 the iron bars if rainfall has occured in that building.

 You can refer to the below image for clear understanding of the problem



 Input
 "The first line of the input contains an integer T denoting the number of test cases
 "The first line of each test case contains a single integer N denoting the total number of bars
 that can be arranged horizontally
 The second line of each test case contains N space-separated integers A0, A1, ..., AN-1 denoting
 the bars which are placed vertically one above the other at each place A0,A1...AN-1 respectively

 Output
 For each test case, output a single line containing a single integer max which contains the
 maximum units of accumulation of water assuming a unit as the place between alternate bars

 Constraints
 1≤ T ≤ 100
 1≤N≤ 1000
 1≤ A0,A1,....AN-1 ≤ 1000

 Example
 Input:
 2
 6
 3 0 0 2 0 4
 6
 3 0 3 3 3 3
 Output:
 10
 3

 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        new TrappingRainWater().runner();
    }

    public void runner() throws Exception {
        int T = nextInt();

        while ( T --> 0 ) {
            int N = nextInt();
            int arr[] = nextIntArr(N);
            pw.println(solver(arr, N));
        }

        pw.flush();
    }

    private int solver(int arr[], int N) {
        if(N<3) return 0;

        int leftMax[] = new int[N], rightMax[] = new int[N], lM, rM;;

        int maxIndex=0;

        lM=0; rM=N-1;
        leftMax[0]=rightMax[N-1]=-1;

        leftMax[1]=lM;
        rightMax[N-2]=rM;

        for(int i=1; i<N; i++) {
            maxIndex = arr[i] >= arr[maxIndex] ? i : maxIndex;
            leftMax[i]=lM;
            rightMax[N-i-1]=rM;

            lM = arr[i]>=arr[lM] ? i : lM;
            rM = arr[N-i-1]>=arr[rM] ? N-i-1 : rM;
        }

        // Go backward from max index
        int waterTrappedLeft=0;
        int i=maxIndex;
        while ( i > 0 ) {
            int nextIndex=leftMax[i];
            int maxLevel=Math.min(arr[nextIndex], arr[i]);
            for(int z=nextIndex+1; z<i; z++) {
                waterTrappedLeft += maxLevel-arr[z];
            }
            i=nextIndex;
        }

        // Go backward from max index
        int waterTrappedRight=0;
        i=maxIndex;
        while ( i < N-1 ) {
            int nextIndex=rightMax[i];
            int maxLevel=Math.min(arr[nextIndex], arr[i]);
            for(int z=nextIndex+1; z<i; z++) {
                waterTrappedRight += maxLevel-arr[z];
            }
            i=nextIndex;
        }

        return waterTrappedRight + waterTrappedLeft;
    }

    private int[] nextIntArr(int N) throws IOException {
        String s = br.readLine();
        String[] split = s.split("\\s");
        int[] arr = new int[N];

        for(int i=0; i<split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    private List<Integer> nextIntList() throws IOException {
        String s = br.readLine();
        String[] split = s.split("\\s");
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return list;
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

}
