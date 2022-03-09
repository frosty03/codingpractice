package com.example.stub.unassigned;

/**
 * Problem Statement: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Submitted Solution: https://leetcode.com/submissions/detail/653891975/
 *
 * Kth Largest Element in an Array
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++) {
            q.add(nums[i]);
        }

        while(k-->1) {
            q.poll();
        }
        return q.poll();
    }

    public static void main(String[] args) {
        System.out.println("return:" + new KthLargestElement().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println("return:" + new KthLargestElement().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
