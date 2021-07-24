
/**
 * problem statement: https://www.interviewbit.com/problems/nearest-smaller-element/
 * submitted solution: <interviewbit doesn't provide permalink to submitted solution>

 Given an array, find the nearest smaller element G[i] for every element A[i] in the array 
 such that the element has an index smaller than i.

 More formally,

 G[i] for an element A[i] = an element A[j] such that 
 j is maximum possible AND 
 j < i AND
 A[j] < A[i]
 Elements for which no smaller element exist, consider next smaller element as -1.

 Input Format

 The only argument given is integer array A.
 Output Format

 Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such 
 element occurs G[i] should be -1.
 For Example

 Input 1:
 A = [4, 5, 2, 10, 8]
 Output 1:
 G = [-1, 4, -1, 2, 2]
 
 */

import java.util.ArrayList;
import java.util.Stack;

public class PrevSmallar {
    public static void main(String[] args) {
        System.out.println(new PrevSmallar().prevSmaller(getArrayList(new int[]{4, 5, 2, 10, 8})));
        System.out.println(new PrevSmallar().prevSmaller(getArrayList(new int[]{3, 2, 1})));
        System.out.println(new PrevSmallar().prevSmaller(getArrayList(new int[]{4,5,6,3,7,7,7,7,3,8,8,2,2,9})));
    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> maxStack = new Stack<>();
        ArrayList<Integer> O = new ArrayList<>();
        for(int i=0; i<A.size(); i++) {
            while(!maxStack.isEmpty() && maxStack.peek()>=A.get(i))
                maxStack.pop();

            if(!maxStack.isEmpty()) {
                O.add(maxStack.peek());
            }
            else {
                O.add(-1);
            }
            maxStack.push(A.get(i));
        }

        return O;
    }

    public static ArrayList<Integer> getArrayList(int[] ints) {
        ArrayList al = new ArrayList<>();
        for(int i=0; i<ints.length; i++) {
            al.add(ints[i]);
        }
        return al;
    }
}

