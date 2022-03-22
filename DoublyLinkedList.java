package com.datastructure.code.datastructure;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private LinkNode head;
    private LinkNode tail;
    private int length;

    private static class LinkNode{
        private int data;
        private LinkNode previous;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int lengthOfDLL(){
        return length;
    }

    public void addNode(int data){
        LinkNode node = new LinkNode(data);
        if(isEmpty()){
            head = node;
        }
        else {
            tail.next = node;
        }
        node.previous = tail;
        tail = node;
        length++;
    }

    public void addNodeAtStart(int data){
        LinkNode node = new LinkNode(data);
        if(isEmpty()){
            tail = node;
        }
        else{
            head.previous = node;
        }
        node.next = head;
        head = node;
        length++;
    }

    public void displayForward(){
        LinkNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        LinkNode temp = tail;
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public LinkNode deleteFirstNode(){
        if(head == null){
            throw new NoSuchElementException();
        }
        LinkNode temp = head;
        if(head == tail){
            tail = null;
        }
        else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public LinkNode deleteLastNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            LinkNode temp = tail;
            tail.previous.next = null;
            tail = tail.previous;
            length--;
            return temp;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList dLL = new DoublyLinkedList();
        dLL.addNode(23);
        dLL.addNode(34);
        dLL.addNode(56);
        dLL.addNode(62);
        dLL.addNode(12);
        dLL.addNode(72);
        dLL.addNode(90);
        dLL.displayForward();
        dLL.displayBackward();
//        dLL.addNodeAtStart(11);
//        dLL.addNodeAtStart(12);
//        dLL.addNodeAtStart(13);
//        dLL.addNodeAtStart(14);
//        dLL.addNodeAtStart(15);
        dLL.addNodeAtStart(16);
        dLL.displayForward();
        dLL.displayBackward();
        dLL.deleteFirstNode();
        dLL.displayForward();
        dLL.deleteLastNode();
        dLL.displayForward();

    }
}
