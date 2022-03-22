package com.datastructure.code.datastructure;

import java.util.NoSuchElementException;

public class CircularLinkedLIst {
    private LinkNode last;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
        }
    }

    public void createCircularLL(){
        LinkNode first = new LinkNode(21);
        LinkNode second = new LinkNode(22);
        LinkNode third = new LinkNode(23);
        LinkNode fourth = new LinkNode(24);
        LinkNode fifth = new LinkNode(25);
        last = fifth;
        first.next =second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
    }

    public void displayCLL(){
        if(last == null){
            System.out.println("null");
        }
        else{
            LinkNode temp = last.next;
            while(temp!=last){
                System.out.print(temp.data+" --> ");
                temp = temp.next;
            }
            System.out.println(last.data);
        }
    }

    public void addNode(int data){
        LinkNode newNode = new LinkNode(data);
        if(last == null ){
            last = newNode;
            last.next = last;
        }
//        else if(last.next == last){
//            last.next = newNode;
//            newNode.next = last;
////            last = newNode;
//        }
        else{
            LinkNode temp = last.next;
            while(temp.next!= last){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = last;
        }
    }

    public void addNodeAtFirst(int data){
        LinkNode node = new LinkNode(data);
        if(last == null){
            last = node;
        }
        else{
            node.next = last.next;
        }
        last.next = node;
    }

    public void addNodeLast(int data){
        LinkNode newNode = new LinkNode(data);
        if(last == null){
            last = newNode;
            last.next = last;
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteFirst(){
        if(last == null){
            throw new NoSuchElementException();
        }
        LinkNode first = last.next;
        if(last.next == last){
            last = null;
        }
        else{
            last.next = first.next;
        }
        first.next = null;
    }

    public static void main(String[] args) {
        CircularLinkedLIst cll = new CircularLinkedLIst();
        cll.createCircularLL();
        cll.displayCLL();
        CircularLinkedLIst cLL = new CircularLinkedLIst();
        cLL.addNode(12);
        cLL.addNode(13);
        cLL.addNode(14);
        cLL.addNode(15);
        cLL.addNode(16);
        cLL.displayCLL();
        CircularLinkedLIst CirLL = new CircularLinkedLIst();
        CirLL.addNodeAtFirst(10);
        CirLL.addNodeAtFirst(9);
        CirLL.addNodeAtFirst(13);
        CirLL.addNodeAtFirst(14);
        CirLL.addNodeAtFirst(15);
        CirLL.addNodeAtFirst(16);
        CirLL.addNodeLast(12);
        CirLL.displayCLL();
        CircularLinkedLIst cl = new CircularLinkedLIst();
        cl.addNodeLast(1);
        cl.addNodeLast(3);
        cl.addNodeLast(5);
        cl.displayCLL();
        CirLL.deleteFirst();
        CirLL.displayCLL();
        CirLL.deleteFirst();
        CirLL.displayCLL();
        CirLL.deleteFirst();
        CirLL.displayCLL();
        CirLL.deleteFirst();
        CirLL.displayCLL();
    }
}
