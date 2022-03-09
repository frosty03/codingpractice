package com.example.stub.tree;

/**
 * Problem Statement: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Submitted Solution: https://leetcode.com/submissions/detail/654580691/
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}

public class LCAOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        if(leftSubtree != null && rightSubtree != null) {
            return root;
        }
        if(leftSubtree != null) return leftSubtree;
        if(rightSubtree != null) return rightSubtree;
        return null;
    }

    public static void main(String[] args) {
//        3,5,1,6,2,0,8,null,null,7,4
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5; n3.right = n1;
        n5.left = n6; n5.right = n2;
        n2.left = n7; n2.right = n4;
        n1.left = n0; n1.right = n8;

//        System.out.println("3" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(5), new TreeNode(1)).val);
//        System.out.println("3" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(5), new TreeNode(3)).val);
//        System.out.println("3" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(3), new TreeNode(7)).val);
        System.out.println("5" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(4), new TreeNode(6)).val);
        System.out.println("1" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(0), new TreeNode(8)).val);
        System.out.println("2" + new LCAOfBT().lowestCommonAncestor(n3, new TreeNode(7), new TreeNode(4)).val);
    }
}
