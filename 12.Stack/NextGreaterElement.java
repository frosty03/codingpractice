package com.example.stub.unassigned;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Problem Statement: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=f9db55d90783e3f51b6455736bd1deb2&pid=701343&user=frosty03
 *
 * Next Greater Element
 *
 Input:
 N = 4, arr[] = [1 3 2 4]
 Output:
 3 4 4 -1
 Explanation:
 In the array, the next larger element
 to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ?
 since it doesn't exist, it is -1.
 *
 */

public class NextGreaterElement {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Long> ng = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(ng.size() > 0 && ng.peek()<arr[i]) {
                ng.pop();
            }
            if(ng.size() > 0) {
                ans[i] = ng.peek();
            }
            else {
                ans[i] = -1;
            }
            ng.push(arr[i]);
        }
        // Your code here
        return ans;
    }

    public static void main(String[] args) {
        String [] sl = {
                "1 3 2 4",
                "6 8 0 1 3"
        };

        for(String s: sl) {
            long[] longs = Arrays.stream(s.split(" ")).mapToLong(l -> Long.valueOf(l)).toArray();
            long[] ans = nextLargerElement(longs, longs.length);
            for(int i=0; i<ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
