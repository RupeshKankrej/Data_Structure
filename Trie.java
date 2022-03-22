package com.datastructure.code.datastructure;

import java.util.Locale;

public class Trie {

    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    private static class TrieNode{
        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public void insert(String word){
        if(word == null || word.isEmpty()){
            throw new IllegalArgumentException("Invalid Input");
        }
        word = word.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }
            else{
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Rupesh");
    }

}
