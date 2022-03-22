package com.datastructure.code.datastructure;

public class DeletingLoop{
    private LinkNode head;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void loopedLL(){
        LinkNode first = new LinkNode(1);
        LinkNode second = new LinkNode(2);
        LinkNode third = new LinkNode(3);
        LinkNode fourth = new LinkNode(4);
        LinkNode fifth = new LinkNode(5);
        LinkNode sixth = new LinkNode(6);
        LinkNode seventh = new LinkNode(7);
        LinkNode eighth = new LinkNode(8);
        LinkNode ninth = new LinkNode(9);
        LinkNode tenth = new LinkNode(10);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        tenth.next = seventh;
    }

    public boolean isLoopPresent(){
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr!= null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public LinkNode startingOfLoop(){
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    public LinkNode getStartingNode(LinkNode slowPtr){
        LinkNode temp = head;
        while(temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public LinkNode deleteLoop(){
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return removeLoop(slowPtr);
            }
        }return null;
    }
    public LinkNode removeLoop(LinkNode slowPtr){
        LinkNode temp = head;
        while(temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return head;
    }

    public void displayLL(LinkNode head){
        LinkNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main (String[] args) {
        DeletingLoop linkedList = new DeletingLoop();
        linkedList.loopedLL();
        System.out.println("The loop Status: "+linkedList.isLoopPresent());
        int startingNode = linkedList.startingOfLoop().data;
        System.out.println("The first Node of the loop is: "+startingNode);

        linkedList.displayLL(linkedList.deleteLoop());
        System.out.println();
    }
}