package com.example.stub.unassigned;

/**
 *
 * Problem Statement: https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 * Submitted Solution: https://practice.geeksforgeeks.org/viewSol.php?subId=6ec2f5662e37847cb4ad5390e25e00b3&pid=700043&user=frosty03
 *
 * Add two numbers represented by linked lists 
 *
Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
 *
 */

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return this.data + " ";
    }
}

public class Add2LinkedLists { 
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        first = reverse(first);
        second = reverse(second);

        Node fi = first, si = second;
        int carry=0;
        Node total = null, ti = null;

        while (fi!=null && si!=null) {
            int num = fi.data + si.data + carry;
            if(num > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            if(ti == null) {
                total = ti = new Node(num%10);
            }
            else {
                ti.next = new Node(num%10);
                ti = ti.next;
            }
            fi = fi.next;
            si = si.next;
        }

        Node z = fi != null ? fi : si;

        while (z!=null) {
            int temp = carry + z.data;
            if(temp > 9) {
                carry = 1;
                temp = temp%10;
            }
            else {
                carry = 0;
            }
            if(ti == null) {
                total = ti = new Node(temp);
            }
            else {
                ti.next = new Node(temp);
                ti = ti.next;
            }
            z = z.next;
        }
        if(carry==1) {
            if(ti == null) {
                total = new Node(carry);
            }
            else {
                ti.next = new Node(carry);
            }
        }

        // return head of sum list
        return reverse(total);
    }

    static Node reverse(Node start) {
        Node prev = null, next;

        next = start.next;
        while(next != null) {
            start.next = prev;
            prev = start;
            start = next;
            next = start.next;
        }
        start.next = prev;

        return start;
    }


    public static void main(String[] args) {
//        Node n4 = new Node(4);
//        Node n2 = new Node(2);
//        Node n22 = new Node(3);
//        Node n1 = new Node(1);
//        Node n8 = new Node(8);
//        Node n7 = new Node(7);
//        Node n6 = new Node(6);
//        Node n5 = new Node(5);
//
//        n1.next = n2;
//        n2.next = n22;
//        n22.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//
//        print(n1);
//        Node ret = new ReverseNumsLinkedList().reverse(n1);
//        System.out.println();
//        print(ret);
//        System.out.println();

        Node na4 = new Node(9);
        Node na5 = new Node(9);
        Node na3 = new Node(9);
        na4.next = na5;
        na5.next = na3;

        Node nb3 = new Node(9);
        Node nb4 = new Node(9);
        Node nb5 = new Node(9);
        nb3.next = nb4;
        nb4.next = nb5;

        Node node = addTwoLists(na4, nb3);
        while (node!=null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node=node.next;
        }
    }
}
