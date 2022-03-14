package com.example.stub.unassigned;


import java.util.PriorityQueue;

/**
 *
 * Problem Statement: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=b64a3c9a3929d5b3efa8f23392d6a73c&pid=701342&user=frosty03
 *
 * Stock span problem
 *
 Input:
 N = 7, price[] = [100 80 60 70 60 75 85]
 Output:
 1 1 1 2 1 4 6
 *
 */

class Tuple implements Comparable<Tuple> {
    int price;
    int index;

    public Tuple(int price, int index) {
        this.price = price;
        this.index = index;
    }

    @Override
    public int compareTo(Tuple o) {
        return Integer.valueOf(this.price).compareTo(o.price);
    }

    @Override
    public String toString() {
        return String.valueOf(this.price + " " + this.index);
    }
}

public class StockSpan {
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        n = price.length;
        int ret[] = new int[n];
        PriorityQueue<Tuple> ts = new PriorityQueue<>();

        for(int i=n-1; i>=0; i--) {
            while (ts.size() > 0 && ts.peek().price < price[i]) {
                Tuple t = ts.poll();
                ret[t.index] = t.index-i;
            }
            ts.add(new Tuple(price[i], i));
        }

        while(ts.size() != 0) {
            Tuple t = ts.poll();
            ret[t.index] = t.index+1;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] ints = calculateSpan(new int[]{100, 80, 60, 70, 60, 75, 85}, 1);
        for(int i=0; i<ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}
