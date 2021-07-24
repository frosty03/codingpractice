
/**
 * problem statement: https://leetcode.com/problems/maximum-subarray-min-product/
 * leetcode submission: https://leetcode.com/submissions/detail/527433658/
 *
 The min-product of an array is equal to the minimum value in the array multiplied
 by the array's sum.

 For example, the array [3,2,5] (minimum value is 2) has a min-product of
 2 * (3+2+5) = 2 * 10 = 20.
 Given an array of integers nums, return the maximum min-product of any non-empty
 subarray of nums. Since the answer may be large, return it modulo 109 + 7.

 Note that the min-product should be maximized before performing the modulo operation.
 Testcases are generated such that the maximum min-product without modulo will fit
 in a 64-bit signed integer.

 A subarray is a contiguous part of an array.
 */

import java.util.Stack;

public class MaxSubarray3 {

    public static void main(String[] args) {
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{10}));;
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{1,2,3,4,10}));;
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{1,2,3,2}));;
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{2,3,3,1,2}));;
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{3,1,5,6,4,2}));;
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{1,1,3,2,2,2,1,5,1,5}));
        System.out.println(new MaxSubarray3().maxSumMinProduct(new int[]{2,5,4,2,4,5,3,1,2,4}));
    }

    public int maxSumMinProduct(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        long sums[] = new long[nums.length+1];

        for(int i=1; i<=nums.length; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }

        long max = Long.MIN_VALUE;
        for(int i=0; i<=nums.length; i++) {

            int min = i==nums.length ? 0 : nums[i];

            while(!stack.isEmpty() && min<=nums[stack.peek()]) {
                int pop = stack.pop();
                int j = stack.isEmpty() ? 0 : stack.peek()+1;
                long sumDifference = sums[i]-sums[j];
                long product = sumDifference * nums[pop];
                max = Math.max(max, product);
            }
            stack.push(i);
        }

        return (int) (max%1000000007);
    }
}

