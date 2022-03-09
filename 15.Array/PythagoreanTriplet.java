package com.example.stub.unassigned;

/**
 * Problem Statement: https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=25ee399464db1d8fc4d8a81aeb22a278&pid=702805&user=frosty03
 *
 * Pythagorean Triplet
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PythagoreanTriplet {
    boolean checkTriplet(int[] arr2, int n) {
        List<Integer> larr = Arrays.stream(arr2)
                .boxed()
                .map(e -> e*e)
                .collect(java.util.stream.Collectors.toList());

        Collections.sort(larr);

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(Collections.binarySearch(larr,larr.get(i)+larr.get(j)) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PythagoreanTriplet().checkTriplet(new int[]{3, 2, 4, 6, 5}, 5));
        System.out.println(new PythagoreanTriplet().checkTriplet(new int[]{3, 8, 5}, 3));
        System.out.println(new PythagoreanTriplet().checkTriplet(new int[]{1, 2, 3}, 3));
    }
}
