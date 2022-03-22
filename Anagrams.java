package com.datastructure.code.datastructure;

import java.util.Scanner;

public class Anagrams {
//    Anagrams are the words where letters of the words remain the same but their sequence may change
//    eg. (tea, ate), (made, dame), etc.

    public boolean isAnagram(String a , String b){
        if(a.length()!=b.length()){
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int sum = 0;
        for(char c = 'a'; c<='z'; c++){
            for(int i = 0; i<a.length(); i++){
                if(a.charAt(i)==c){
                    sum++;
                }
                if(b.charAt(i)==c){
                    sum++;
                }
            }
            if(sum!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagrams an = new Anagrams();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if(an.isAnagram(a, b)){
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not Anagram");
        }
    }
}
