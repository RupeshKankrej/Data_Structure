package com.datastructure;

public class DeletingKeySLL {
    private LinkNode head;
    private LinkNode tail;

    private static class LinkNode{
        private int data;
        private LinkNode next = null;

        public LinkNode(int data){
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
        }else{
            LinkNode current = head;
            while(current != null){
                System.out.print(current.data +" --> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public void deleteKey(int key){
        LinkNode current = head;
        LinkNode temp = null;
        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null) return;
        temp.next = current.next;
    }

    public static void main(String[] args) {
        DeletingKeySLL dl = new DeletingKeySLL();
        dl.addNode(13);
        dl.addNode(43);
        dl.addNode(39);
        dl.addNode(70);
        dl.addNode(67);
        dl.addNode(65);
        dl.addNode(19);
        dl.addNode(28);
        dl.displayLL(dl.head);
        dl.deleteKey(65);
        dl.displayLL(dl.head);
        dl.deleteKey(15);
        dl.displayLL(dl.head);
    }
}
