package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=51f76375759c51f0d7c2f31ebeff36c0&pid=700013&user=frosty03
 *
 * Reverse a Linked List in groups of given size.
 *
 Input:
 LinkedList: 1->2->2->4->5->6->7->8
 K = 4
 Output: 4 2 2 1 8 7 6 5
 Explanation:
 The first 4 elements 1,2,2,4 are reversed first
 and then the next 4 elements 5,6,7,8. Hence, the
 resultant linked list is 4->2->2->1->8->7->6->5.
 *
 */

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(this.data);
    }
}

public class ReverseLinkedList {
    public static Node reverse(Node node, int k)
    {
        Node returnNode = null, next, prev, prevFirst=null, first;
        while (node != null) {
            first = node;
            prev=null;
            for(int i=0; i<k && node!=null; i++) {
                next = node.next;
                node.next=prev;
                prev=node;
                node=next;
            }
            if(prevFirst!=null) prevFirst.next=prev;
            if(returnNode==null){
                returnNode = prev;
            }
            prevFirst=first;
        }
        return returnNode;
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();

        Node n4 = new Node(4);
        Node n2 = new Node(2);
        Node n22 = new Node(3);
        Node n1 = new Node(1);
        Node n8 = new Node(8);
        Node n7 = new Node(7);
        Node n6 = new Node(6);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n22;
        n22.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        print(n1);
        Node ret = reverse(n1, 3);
        System.out.println();
        print(ret);
        System.out.println();
    }
}
