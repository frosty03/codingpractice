/**
 *

 Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 Submitted Solution: https://leetcode.com/submissions/detail/517112904/





 ********************************************
 *********** PROBLEM STATEMENT  *************
 ********************************************




 373. Find K Pairs with Smallest Sums
 Medium
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u, v) which consists of one element from the first array and one element from the second array.

 Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 Example 1:
 Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 Output: [[1,2],[1,4],[1,6]]
 Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:
 Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 Output: [[1,1],[1,1]]
 Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:
 Input: nums1 = [1,2], nums2 = [3], k = 3
 Output: [[1,3],[2,3]]
 Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]


 Constraints:
 1 <= nums1.length, nums2.length <= 104
 -109 <= nums1[i], nums2[i] <= 109
 nums1 and nums2 both are sorted in ascending order.
 1 <= k <= 1000

 *
 */


import java.util.*;

public class R02MaxHeapMinSumCombination {
    class Pairs{
        int l, k;

        public Pairs(int l, int k) {
            this.l = l;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pairs pairs = (Pairs) o;
            return l == pairs.l && k == pairs.k;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + new Integer(l).hashCode();
            hash = hash * 31 + new Integer(k).hashCode();
            return hash;
        }
    }
    class Tuples {
        int sum, l, r;

        public Tuples(int sum, int l, int r) {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> returnList = new ArrayList<>();
        Set<Pairs> pairs = new HashSet<>();
        Queue<Tuples> priorityQueue = new PriorityQueue<Tuples>(
                (node1, node2) -> Integer.compare(node1.sum, node2.sum));

        pairs.add(new Pairs(0, 0));
        priorityQueue.add(new Tuples(nums1[0]+nums2[0], 0, 0));

        for (int i = 1; i <= k && priorityQueue.size()>0; i++) {
            Tuples tuple = priorityQueue.poll();
            int l=tuple.l, r=tuple.r;
            returnList.add(Arrays.asList(nums1[l], nums2[r]));

            Pairs lPair = new Pairs(l + 1, r);
            Pairs rPair = new Pairs(l, r+1);
            if(l+1< nums1.length && !pairs.contains(lPair)) {
                pairs.add(lPair);
                priorityQueue.add(new Tuples(nums1[l+1]+nums2[r],l+1, r));
            }
            if(r+1< nums2.length && !pairs.contains(rPair)) {
                pairs.add(rPair);
                priorityQueue.add(new Tuples(nums1[l]+nums2[r+1], l, r+1));
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        int nums1[] = {1,2}, nums2[] = {3}, k = 3;
        List<List<Integer>> lists = new R02MaxHeapMinSumCombination().kSmallestPairs(nums1, nums2, 9);
        System.out.println(lists);
    }
}

