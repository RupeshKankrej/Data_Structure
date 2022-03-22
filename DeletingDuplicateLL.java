package com.datastructure.code.datastructure;

import java.util.HashSet;
import java.util.Set;

public class DeletingDuplicateLL {
    private static Node head = null;

    class Node{
        private int data;
        private Node next = null;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public Node deleteDupli(){
        if(head == null){
            return null;
        }
        Node previous = head;
        Node cur = head.next;
        Set<Integer> set = new HashSet<>();
        if(cur == null){
            return head;
        }
        set.add(previous.data);
        while(cur != null){
            if(set.contains(cur.data)){
                previous.next = cur.next;
                cur = cur.next;
            }
            else{
                set.add(cur.data);
                previous = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public void createLinkedList(){
        Node first = new Node(12);
        Node second = new Node(24);
        Node third = new Node(36);
        Node fourth = new Node(12);
        Node fifth = new Node(48);
        Node sixth = new Node(12);
        Node seventh = new Node(36);
        Node eighth = new Node(60);
        head = first;
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
    }

    public void display(Node head){
        Node cur = head;
        while(cur.next!= null){
            System.out.print(cur.data+" --> ");
            cur = cur.next;
        }
        System.out.print(cur.data);
    }

    public static void main(String[] args) {
        DeletingDuplicateLL dl = new DeletingDuplicateLL();
        dl.createLinkedList();
        dl.display(head);
        dl.deleteDupli();
        System.out.println();
        dl.display(head);
    }
}
