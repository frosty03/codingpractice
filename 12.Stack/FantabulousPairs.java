package com.example.stub.array;

/**

 Problem Statement: https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/mancunian-and-fantabulous-pairs/
 Submitted Solution: https://www.hackerearth.com/submission/61443811/

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class FantabulousPairs {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);

    int N, arr[], maxNext[], maxPrev[], max[];

    public static void main(String[] args) {
        new FantabulousPairs2().runner();
    }

    private void runner() {
        N = nextInt();
        arr = new int[N];
        max = new int[N];
        maxNext = new int[N];
        maxPrev = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = nextInt();

        makeMaxNext();
        makeMaxPrev();

        for ( int i=0; i<N; i++ ) {
            if(maxNext[i]!=i)
                max[maxNext[i]-i] = Math.max(max[maxNext[i]-i], i-maxPrev[i]);
        }

        pw.println(Arrays.stream(max).sum());
        pw.flush();
    }

    class Pair{ int num, index;
        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    private void makeMaxNext() {
        Stack<Pair> stack = new Stack<>();

        for (int i=N-1; i>=0; i--) {
            maxNext[i] = i;

            while(!stack.isEmpty() && stack.peek().num < arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty())
                maxNext[i]=stack.peek().index;

            stack.push(new Pair(arr[i], i));
        }
    }

    private void makeMaxPrev() {
        Stack<Pair> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            maxPrev[i] = -1;

            while(!stack.isEmpty() && stack.peek().num < arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) maxPrev[i]=stack.peek().index;

            stack.push(new Pair(arr[i], i));
        }
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
