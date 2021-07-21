
/**
 * Problem statement: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * Submitted solution: https://leetcode.com/submissions/detail/525460986/
 *
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 *
 * Example 1:
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallarOnRight {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
//        new CountSmallarOnRight().runner();
        int arr[] = {2, 3, -1, 0, -1};
        List<Integer> ret = new CountSmallarOnRight().countSmaller(arr);

        System.out.println(ret);
    }

    private void runner() {

        int arr[] = {50, 40, 70, 30, 80, 20, 90, 35, 10, 60};

        BinTree root = new BinTree(arr[0]);
        pw.print(arr[0] + ", ");

        System.out.println("arr[i]: " + arr[0] + ": -> countleft = " + 0);
        for(int i=1; i<arr.length; i++) {
            pw.print(arr[i] + ", ");
            System.out.println("arr[i]: " + arr[i] + ": -> countleft = " + (root.insert(arr[i], 0)));
        }
        pw.flush();

        List<Integer> integers = countSmaller(arr);
    }

    class BinTree {
        int val;
        BinTree left, right;
        int numLeftSubtree=1;

        @Override
        public String toString() {
            return "BinTree{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", numLeftSubtree=" + numLeftSubtree +
                    '}';
        }

        BinTree(int val) {
            this.val=val;
        }

        int insert(int val, int prevwt) {
            if(val <= this.val) {
                this.numLeftSubtree++;
                if(this.left != null) {
                    return this.left.insert(val, prevwt);
                }
                else {
                    this.left=new BinTree(val);
                    return prevwt;
                }
            }
            else {
                if(this.right != null) {
                    return this.right.insert(val, prevwt+this.numLeftSubtree);
                }
                else {
                    this.right=new BinTree(val);
                    return prevwt+this.numLeftSubtree;
                }

            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> smallar = new ArrayList<>();

        BinTree root = new BinTree(nums[nums.length-1]);
        smallar.add(0);

        for (int i=nums.length-2; i>=0; i--) {
            smallar.add(root.insert(nums[i], 0));
        }

        Collections.reverse(smallar);
        return smallar;
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
