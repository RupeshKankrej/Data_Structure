package com.datastructure;

import java.util.Scanner;

public class PalindromeWord {

    public boolean isPalidrome1(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void isPalidrome(String word){
        int k = 0;
        for(int i =0, j =word.length()-1; i<=j; i++, j--){
            if(word.charAt(i) != word.charAt(j)){
                k =1;
            }
        }
        System.out.println((k==0)?"Yes":"No");
    }

    public static void main(String[] args) {
        PalindromeWord pw = new PalindromeWord();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to be checked: ");
        String word = sc.next();
        System.out.println(pw.isPalidrome1(word));
        pw.isPalidrome(word);
    }
}
