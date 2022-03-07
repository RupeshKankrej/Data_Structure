package com.datastructure;

import java.util.Stack;

public class ReversingString {

    public String ReverseUsingStack(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            stack.push(c);
        }
        for(int i =0; i<str.length();i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public String reverseUsingArray(String str){
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length-1;
        while(start<end){
            char temp = chars[start];
            chars[start] =chars[end];
            chars[end] = temp;
            start ++;
            end --;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReversingString rs = new ReversingString();
        String name = "rupesh";
        System.out.println(rs.ReverseUsingStack(name));
        System.out.println(rs.reverseUsingArray(name));
    }
}
