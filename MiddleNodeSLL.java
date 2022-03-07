package com.datastructure;

public class MiddleNodeSLL {
    private LinkNode head;
    private LinkNode tail= null;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        private LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        LinkNode node = new LinkNode(data);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
    }

    public void displayLL(LinkNode head){
        if(head == null){
            System.out.println("null");
        }
        else{
            LinkNode current = head;
            while(current != null){
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public LinkNode middleNode(){
        if(head == null){
            return null;
        }
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr= slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public LinkNode nthValueFromEnd(int n){
        if(head == null){
            return null;
        }
        if(n<=0){
            throw new IllegalArgumentException("Invalid value: n = "+n);
        }
        LinkNode mainPtr = head;
        LinkNode refPtr = head;
        int count = 0;
        while(count<n){
            if(refPtr== null){
                throw new IllegalArgumentException(n +" is greater than the number of nodes in list.");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr!=null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public static void main(String[] args) {
        MiddleNodeSLL ml = new MiddleNodeSLL();
        ml.addNode(14);
        ml.addNode(56);
        ml.addNode(18);
        ml.addNode(57);
        ml.addNode(90);
        ml.addNode(34);
        ml.addNode(61);
        ml.addNode(45);
        ml.displayLL(ml.head);
        System.out.println("The middle node of the lined list is: "+ml.middleNode().data);
        System.out.println("The 4 node from the bottom of linked list is: " +ml.nthValueFromEnd(4).data);
        System.out.println("The 7 node from the bottom of linked list is: " +ml.nthValueFromEnd(5).data);
    }
}
