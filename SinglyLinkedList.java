package com.datastructure;

public class SinglyLinkedList {
    private LinkNode head = null;
    private LinkNode tail = null;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        LinkNode newNode = new LinkNode(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayNode(){
        if(head == null){
            System.out.println("The LinkedList is empty");
            return;
        }
        LinkNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void lengthOfLinkedList(){
        if(head == null){
            System.out.println("Length of the LinkedList is: 0");
        }
        else{
            int count=0;
            LinkNode current = head;
            while(current!= null){
                count ++;
                current = current.next;
            }
            System.out.println("The length of the LinkedList is: "+count);
        }
    }

    public void addNodeFirst(int data){
        LinkNode newNode = new LinkNode(data);
        newNode.next = head;
        head = newNode;
    }

//    Entering node at given position (value, position) position value from 1.
   public void addNode(int data, int position){
        LinkNode node = new LinkNode(data);
        if(position == 1){
            node.next = head;
            head = node;
        }
        else{
            LinkNode previous = head;
            int count =1;
            while(count < position-1){
                previous = previous .next;
                count++;
            }
            LinkNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
   }

//   Deleting the first head of the linked list.
    public LinkNode deleteFirst(){
        if (head == null){
            return null;
        }
        LinkNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

//    Deleting the last node of the linked list.
    public LinkNode deleteLast(){
        if(head == null || head.next ==null){
            return head;
        }
        LinkNode previous = null;
        LinkNode current = head;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

//    Deleting the element from the given position from the Linked list.
    public LinkNode deleteNode(int position){
        if(position==1){
            head = head.next;
            return head;
        }
        LinkNode previous = head;
        int count = 1;
        while(count < position -1){
            previous = previous.next;
            count++;
        }
        LinkNode current = previous.next;
        previous.next = current.next;
        return current;
    }

//    Searching the node in the linked list.
    public boolean search(int nodeToFind){
        LinkNode current = head;
        while(current!=null){
            if(current.data == nodeToFind){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        Entering the data in the linked list:
        sll.addNode(10);
        sll.addNode(18);
        sll.addNode(6);
        sll.addNode(45);
        sll.addNode(89);
        sll.addNode(12);
        sll.addNode(99);

//        Displaying the linked list:
        sll.displayNode();

//        Finding the length of the linked list:
        sll.lengthOfLinkedList();

//        Adding the node to the linked list:
        sll.addNodeFirst(34);
        sll.displayNode();

//        adding the node at the given position:
        sll.addNode(99,1);
        sll.displayNode();
        sll.addNode(6,8);
        sll.displayNode();
        sll.addNode(100,5);
        sll.displayNode();

//        Deleting the node from the first position:
        sll.deleteFirst();
        sll.displayNode();
        sll.deleteFirst();
        sll.displayNode();
        System.out.println(sll.head.data);

//        Deleting the node from the ending of the linked list:
        sll.deleteLast();
        sll.displayNode();

//        Deleting the node from the given position from the linked list:
        sll.deleteNode(3);
        sll.displayNode();

//        Searching the node in the linked list:
        if(sll.search(99)){
            System.out.println("The node is found.");
        }
        else{
            System.out.println("The node is not found.");
        }
    }
}
