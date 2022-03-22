package com.datastructure.code.datastructure;

public class SortedLInkedLIst {
    private LinkNode head= null;
    private final LinkNode tail = null;

    private static class LinkNode{
        private final int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void displaySoLL(LinkNode head){
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

    public void addNodeToFirst(int data){
        LinkNode node = new LinkNode(data);
        if(head == null){
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
    }

    public void addNodeSLL(int data){
        LinkNode newNode = new LinkNode(data);
        if(head == null){
            return;
        }
        LinkNode current = head;
        LinkNode temp = head;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
    }

    public void removeDuplicate(){
        LinkNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        SortedLInkedLIst soLL = new SortedLInkedLIst();
        soLL.addNodeToFirst(95);
        soLL.addNodeToFirst(78);
        soLL.addNodeToFirst(51);
        soLL.addNodeToFirst(12);
        soLL.displaySoLL(soLL.head);
        soLL.addNodeSLL(45);
        soLL.displaySoLL(soLL.head);
        soLL.addNodeSLL(51);
        soLL.displaySoLL(soLL.head);
        soLL.displaySoLL(soLL.head);
        soLL.addNodeSLL(45);
        soLL.displaySoLL(soLL.head);
        soLL.addNodeSLL(51);
        soLL.displaySoLL(soLL.head);
        soLL.removeDuplicate();
        soLL.displaySoLL(soLL.head);
    }
}
