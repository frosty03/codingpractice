package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://leetcode.com/problems/rotate-image/
 * Submitted Solution: https://leetcode.com/submissions/detail/657035971/
 *
 * 48. Rotate Image - Rotate 2D matrix by 90 deg
 *
 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 */

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        for(int i = 0; i<=n/2; i++) {
            for(int j = i; j<n-i; j++) {
                swap(matrix, i, j);
                swap(matrix, n-j, i);
                swap(matrix, n-i, n-j);
            }
        }
    }

    public void swap(int [][] matrix, int p1i, int p1j) {
        int n = matrix.length-1;
        int p2i = n-p1j;
        int p2j = p1i;
        if(p1i == p2i && p1j == p2j) return;
        matrix[p1i][p1j] += matrix[p2i][p2j];
        matrix[p2i][p2j] = matrix[p1i][p1j] - matrix[p2i][p2j];
        matrix[p1i][p1j] = matrix[p1i][p1j] - matrix[p2i][p2j];
    }

    public void print(int [][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
//                {1, 2},
//                {3, 4}

//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}

//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}

                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };


        RotateMatrix r = new RotateMatrix();
        r.print(matrix);
        r.rotate(matrix);
        System.out.println();
        r.print(matrix);
    }
}
