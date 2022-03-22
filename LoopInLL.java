package com.datastructure.code.datastructure;

public class LoopInLL {
    private LinkNode head;
    private LinkNode tail;

    private static class LinkNode {
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        LinkNode node = new LinkNode(data);
        if(head == null){
            head= node;
            tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void displayLL(){
        if(head == null){
            System.out.println("null");
        }
        else{
            LinkNode current = head;
            while(current != null){
                System.out.print(current.data+" --> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public boolean isLoopPresent(){
        LinkNode firstPtr = head;
        LinkNode secondPtr = head;
        while(firstPtr != null && firstPtr.next != null){
            firstPtr = firstPtr.next.next;
            secondPtr = secondPtr.next;
            if(firstPtr == secondPtr){
                return true;
            }
        }
        return false;
    }

    public void loopedLL(){
        LinkNode first = new LinkNode(1);
        LinkNode second = new LinkNode(2);
        LinkNode third = new LinkNode(3);
        LinkNode fourth = new LinkNode(4);
        LinkNode fifth = new LinkNode(5);
        LinkNode sixth = new LinkNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public LinkNode startingNodeOfLL(){
        LinkNode first = head;
        LinkNode second = head;
        while(first != null && first.next != null){
            first = first.next.next ;
            second = second.next;
            if(second == first){
                return getStartingNode(second);
            }
        }
        return null;
    }

    public LinkNode getStartingNode(LinkNode node){
        LinkNode temp = head;
        while(node != temp){
            node = node.next;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        LoopInLL lL = new LoopInLL();
//        LinkNode loopNode = new LinkNode(3);
//        lL.addNode(1);
//        lL.addNode(2);
//        lL.addNode(loopNode.data);
//        lL.addNode(4);
//        lL.addNode(5);
//        lL.addNode(loopNode.data);
//
//        lL.displayLL();
        LinkNode first = new LinkNode(1);
        LinkNode second = new LinkNode(2);
        LinkNode third = new LinkNode(3);
        LinkNode fourth = new LinkNode(4);
        LinkNode fifth = new LinkNode(5);
        LinkNode sixth = new LinkNode(6);
        lL.head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
//        lL.loopedLL();
        System.out.println("Loop Status: "+lL.isLoopPresent());
        int startingPoint = lL.startingNodeOfLL().data;
        System.out.println("Loop starts from: "+startingPoint);
    }
}
