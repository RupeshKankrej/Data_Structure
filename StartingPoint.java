package com.datastructure.code.datastructure;

public class StartingPoint {
    private LinkNode head;

    private static class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void displayLL(){
        LinkNode current = head;
        while(current!= null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
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

    public boolean isLoopPresent(){
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }

    public LinkNode StartingPoint(){
        LinkNode fastPtr = head;
        LinkNode slowPtr = head;
        while(fastPtr!= null && fastPtr.next != null){
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
        while( slowPtr != temp){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        StartingPoint st = new StartingPoint();
        st.loopedLL();
        System.out.println("Loop Status: "+st.isLoopPresent());
        int startingPoint = st.StartingPoint().data;
        System.out.println("Loop starts from node: "+startingPoint);

    }
}
