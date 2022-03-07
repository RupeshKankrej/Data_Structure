package com.datastructure;

import java.util.EmptyStackException;

public class Stack {

    private LinkNode top;
    private int length;

    private class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data){
            this.data = data;
        }
    }

    public Stack(){
        top = null;
        length = 0;
    }

    public void push(int data){
        LinkNode temp = new LinkNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if(length == 0){
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        length--;
        return value;
    }

    public int pick(){
        if(length ==0){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void printStack(){
        LinkNode temp = top;
        while(temp != null){
            System.out.print(temp.data +" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(34);
        st.push(56);
        st.push(44);
        st.push(21);
        st.push(99);
        st.printStack();
        System.out.println("The first element of the stack is: "+st.pick());
        st.pop();
        st.printStack();
        st.pop();
        st.pop();
        st.printStack();

    }
}
