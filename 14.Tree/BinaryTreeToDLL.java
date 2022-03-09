package com.example.stub.unassigned;

/**
 * Problem Statement: https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=4dfcc32909e13e873d03fbaed6d44ea7&pid=700144&user=frosty03
 *
 * Binary Tree to DLL
 */

class Node
{
    Node left, right;
    int data;

    Node(int d)
    {
        data = d;
        left = right = null;
    }

    @Override
    public String toString() {
        return " " + Integer.toString(this.data);
    }

}

public class BinaryTreeToDLL {

    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        inorder(root);
        return root2;
    }

    Node root2, curr = null;
    void inorder(Node node) {
        if(node.left != null) inorder(node.left);
        push(node.data);
        if(node.right != null) inorder(node.right);
    }

    private void push(int data) {
        if(root2==null) {
            root2 = curr = new Node(data);
        }
        else {
            curr.right = new Node(data);
            curr.right.left = curr;
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
//        Node root = new Node();
        Node n10 = new Node(10);
        Node n12 = new Node(12);
        Node n15 = new Node(15);
        Node n25 = new Node(25);
        Node n30 = new Node(30);
        Node n36 = new Node(36);
        n10.left=n12; n10.right=n15;
        n12.left=n25; n12.right=n30;
        n15.left=n36;

        new BinaryTreeToDLL().bToDLL(n10);

    }
}
