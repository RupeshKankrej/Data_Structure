package com.datastructure;

import com.sun.jdi.connect.spi.TransportService;

import java.util.NoSuchElementException;

public class Queue {

    private LinkNode front;
    private LinkNode rear;
    private int length;

    private class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
        }
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length ==0;
    }

    public Queue(){
        front = null;
        rear = null;
        length = 0;
    }

    public void enqueue(int data){
        LinkNode temp = new LinkNode(data);
        if(isEmpty()){
            front =temp;
        }
        else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public LinkNode dequeue(){
        LinkNode temp = front;
        if(isEmpty()){
            throw new NoSuchElementException();
        } else if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        length--;
        return temp;
    }

    public int peek(){
        return front.data;
    }

    public void printQueue(){
        if(front == null){
            System.out.println("null");
            return;
        }
        LinkNode current = front;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(5);
        q.enqueue(22);
        q.enqueue(23);
        q.enqueue(5);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
    }
}
