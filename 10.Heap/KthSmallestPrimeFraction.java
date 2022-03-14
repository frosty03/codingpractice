package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://leetcode.com/problems/k-th-smallest-prime-fraction/
 * Submitted Solution: https://leetcode.com/submissions/detail/659244825/
 *
 * 786. K-th Smallest Prime Fraction
 *
 Input: arr = [1,2,3,5], k = 3
 Output: [2,5]
 Explanation: The fractions to be considered in sorted order are:
 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
 The third fraction is 2/5.
 *
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestPrimeFraction {

    private int len;

    class Tuple implements Comparable<Tuple> {
        int n;
        int d;
        int ni;
        int di;

        Tuple(int n, int d, int ni, int di) {
            this.n = n;
            this.d = d;
            this.ni = ni;
            this.di = di;
        }

        Tuple(Tuple t) {
            this.n = t.n;
            this.d = t.d;
            this.ni = t.ni;
            this.di = t.di;
        }

        @Override
        public String toString() {
            return n + "/" + d;
        }

        @Override
        public boolean equals(Object o) {
            Tuple t = (Tuple) o;
            return this.n == t.n && this.d == t.d
                    && this.ni == t.ni && this.di == t.di;
        }

        @Override
        public int compareTo(Tuple o) {
            return Double.valueOf((double) this.n/this.d).compareTo(Double.valueOf((double) o.n/o.d));
        }

        @Override
        public int hashCode() {
            return 37 * n+d+ni+di;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Set<Tuple> s = new HashSet<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        len = arr.length - 1;
        Tuple tuple = new Tuple(arr[0], arr[len], 0, len);
        s.add(new Tuple(tuple));
        pq.add(new Tuple(tuple));

        for (int i=0; i<k-1; i++) {
            Tuple poll = pq.poll();
//            System.out.println(poll.n + "/" + poll.d + "  \t->  " + (double)poll.n/poll.d);
            if(poll.ni+1<poll.di) {
                Tuple t1 = new Tuple(arr[poll.ni+1], arr[poll.di], poll.ni+1, poll.di);
                if(!s.contains(t1)) {
                    s.add(new Tuple(t1));
                    pq.add(new Tuple(t1));
                }
            }
            if(poll.ni<poll.di-1) {
                Tuple t2 = new Tuple(arr[poll.ni], arr[poll.di-1], poll.ni, poll.di-1);
                if(!s.contains(t2)) {
                    s.add(new Tuple(t2));
                    pq.add(new Tuple(t2));
                }
            }
        }
        Tuple poll = pq.poll();
//        System.out.println(poll.n + "/" + poll.d + "\t->" + (double)poll.n/poll.d);
        return new int[]{poll.n, poll.d};
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction k = new KthSmallestPrimeFraction();

//        int[] ans = k.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 1);
////        System.out.println(ans[0] + "/" + ans[1]);
//
//        ans = k.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 2);
////        System.out.println(ans[0] + "/" + ans[1]);

        int[] ans = k.kthSmallestPrimeFraction(new int[]{1,7,23,29,47}, 8);
        System.out.println(ans[0] + "/" + ans[1] + "\t->" + (double)ans[0]/ans[1]);

//        ans = k.kthSmallestPrimeFraction(new int[]{1, 7}, 1);
//        System.out.println(ans[0] + "/" + ans[1]);
//
//        ans = k.kthSmallestPrimeFraction(new int[]{1, 3, 7}, 4);
//        System.out.println(ans[0] + "/" + ans[1]);
    }
}
