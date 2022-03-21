package com.example.stub.unassigned;

/**
 * Problem statement: https://leetcode.com/problems/minimum-height-trees/
 * Submitted solution: https://leetcode.com/submissions/detail/659673825/
 *
 Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 Output: [1]
 Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 */

import java.util.*;

public class MinHeightTrees {

    public int max(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public int max(int a, int b, int c) {
        if (a > b && a > c) return a;
        if (b > a && b > c) return b;
        return a > c ? a : c;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        if(n==2) return Arrays.asList(0,1);

        int[] deg = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int max = -1;

        for(int i=0; i<edges.length; i++) {
            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
            max = max(max, deg[edges[i][0]], deg[edges[i][1]]);

            if(adj.get(edges[i][0]) == null) adj.put(edges[i][0], new ArrayList<>());
            if(adj.get(edges[i][1]) == null) adj.put(edges[i][1], new ArrayList<>());
            adj.get(edges[i][0]).add(Integer.valueOf(edges[i][1]));
            adj.get(edges[i][1]).add(Integer.valueOf(edges[i][0]));
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(deg[i] == 1) {
                queue.add(i);
                ans.add(i);
            }
        }

        while(max > 1) {
            ans = new ArrayList<>();
            while(!queue.isEmpty()) {
                Integer poll = queue.poll();
                Integer adjOf1 = adj.get(poll).get(0);
                deg[poll]--;
                deg[adjOf1]--;
                adj.get(adjOf1).remove(poll);
                adj.remove(poll);
                if(!ans.contains(adjOf1)) ans.add(adjOf1);
            }

            max = -1;
            for(int i=0; i<n; i++) {
                max = max(max, deg[i]);
                if(deg[i] == 1 && !queue.contains(i)) {
                    queue.add(i);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinHeightTrees m = new MinHeightTrees();
        List<Integer> minHeightTrees;
        minHeightTrees = m.findMinHeightTrees(4, new int[][]{
                {1, 0},
                {1, 2},
                {1, 3}
        });

        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }
        System.out.println();

        minHeightTrees = m.findMinHeightTrees(6, new int[][]{
                {3,0},{3,1},{3,2},{3,4},{5,4}
        });
        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }
        System.out.println();

        minHeightTrees = m.findMinHeightTrees(6, new int[][]{
                {0,1},
                {2,1},
                {2,3},
                {3,4},
                {3,5}
        });
        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }
        System.out.println();


        minHeightTrees = m.findMinHeightTrees(4, new int[][]{
                {0,1},
                {1,2},
                {2,3},
        });
        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }
        System.out.println();

        minHeightTrees = m.findMinHeightTrees(5, new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {3,4}
        });
        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }

        System.out.println();


        minHeightTrees = m.findMinHeightTrees(10, new int[][]{
                {9,8},
                {8,6},
                {6,0},
                {5,0},
                {7,0},
                {0,1},
                {1,2},
                {2,3},
                {3,4}
        });
        for (Integer i: minHeightTrees) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
