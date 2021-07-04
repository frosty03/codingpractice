
/**
 Problem Statement: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal
 Leetcode Submission: https://leetcode.com/submissions/detail/517154980/



 ********************************************
 *********** PROBLEM STATEMENT  *************
 ********************************************


 1028. Recover a Tree From Preorder Traversal
 Hard

 We run a preorder depth-first search (DFS) on the root of a binary tree.

 At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

 If a node has only one child, that child is guaranteed to be the left child.

 Given the output traversal of this traversal, recover the tree and return its root.


 Example 1:
 Input: traversal = "1-2--3--4-5--6--7"
 Output: [1,2,5,3,4,6,7]

 Example 2:
 Input: traversal = "1-2--3---4-5--6---7"
 Output: [1,2,5,3,null,6,null,4,null,7]

 Example 3:
 Input: traversal = "1-401--349---90--88"
 Output: [1,401,null,349,88,90]

 Constraints:

 The number of nodes in the original tree is in the range [1, 1000].
 1 <= Node.val <= 109

 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecoverATree {
    public class StackTree {
        int n;
        TreeNode treeNode;

        public StackTree(int n, TreeNode treeNode) {
            this.n = n;
            this.treeNode = treeNode;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode tree, root = null;
        char c[] = traversal.toCharArray();
        Stack<StackTree> stack = new Stack<>();

        for(int i=0; i<c.length; i++) {
            int dashcount = 0;
            int num = 0;

            while(c[i]=='-') {dashcount++;i++;}
            while(i<c.length && c[i]>='0' && c[i]<='9') {num=num*10; num+=c[i]-'0'; i++;}
            i--;

            TreeNode tn = new TreeNode(num);
            if(root==null) {
                root = tn;
                stack.push(new StackTree(num, tn));
                continue;
            }
            if(dashcount==stack.size()) {
                StackTree peek = stack.peek();
                stack.push(new StackTree(num, tn));
                peek.treeNode.left = tn;
            }
            else {
                while (stack.size() != dashcount) {
                    stack.pop();
                }
                StackTree peek = stack.peek();
                stack.push(new StackTree(num, tn));
                peek.treeNode.right = tn;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new RecoverATree().recoverFromPreorder("1-401--349---90--88");

        Queue<TreeNode> bfsOfTree = new LinkedList<>();
        bfsOfTree.add(treeNode);
        while(!bfsOfTree.isEmpty()) {
            TreeNode poll = bfsOfTree.poll();
            if(poll.left!=null) bfsOfTree.add(poll.left);
            if(poll.right!=null) bfsOfTree.add(poll.right);
            System.out.print(poll.val + " ");
        }
        System.out.println();
    }
}

