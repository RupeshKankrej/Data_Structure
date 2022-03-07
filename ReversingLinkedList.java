package com.datastructure;

public class ReversingLinkedList {
    private LinkNode head= null;
    private LinkNode tail= null;

    private static class LinkNode{
        private int data;
        private LinkNode next = null;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void insertNode(int node){
        LinkNode newNode = new LinkNode(node);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayLL(LinkNode head){

        if(head == null){
            System.out.println("null");
        }
        else{
            LinkNode current = head;
            while(current!= null){
                System.out.print(current.data+ " --> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public LinkNode reverseLL(){
        if(head== null){
            return null;
        }
        LinkNode current = head;
        LinkNode previous = null;
        LinkNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ReversingLinkedList l = new ReversingLinkedList();
        l.insertNode(23);
        l.insertNode(87);
        l.insertNode(29);
        l.insertNode(7);
        l.insertNode(43);
        l.insertNode(99);
        l.displayLL(l.head);
        l.displayLL(l.reverseLL());

    }
}
