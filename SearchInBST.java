package com.datastructure.code.datastructure;

public class SearchInBST {
    private TreeNode root;

    private static class TreeNode{
        private final int data;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value<root.data){
            root.left = insert(root.left, value);
        }
        else{
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public TreeNode searchKey(int value){
        return searchKey(root, value);
    }

    public TreeNode searchKey(TreeNode root, int value){
        if(root == null|| root.data ==value){
            return root;
        }
        if(root.data>value){
            return searchKey(root.left, value);
        }
        else{
            return searchKey(root.right, value);
        }
    }

    public static void main(String[] args) {
        SearchInBST sr = new SearchInBST();
        sr.insert(6);
        sr.insert(5);
        sr.insert(2);
        sr.insert(3);
        sr.insert(8);
        sr.insert(7);
        sr.insert(9);
        sr.inOrder();
        System.out.println();
        if(sr.searchKey(1)!=null){
            System.out.println("Key value found!!!");
        }
        else{
            System.out.println("Key value not found!!!");
        }
    }
}
