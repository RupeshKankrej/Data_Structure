package com.datastructure;

public class MaxTreeNode {
    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createTree(){
        TreeNode first = new TreeNode(23);
        TreeNode second = new TreeNode(34);
        TreeNode third = new TreeNode(2);
        TreeNode fourth = new TreeNode(8);
        TreeNode fifth = new TreeNode(19);
        TreeNode sixth = new TreeNode(22);
        TreeNode seventh = new TreeNode(25);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = sixth;
        third.left = fifth;
        third.right = seventh;
    }

    public int maxTreeNode(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = maxTreeNode(root.left);
        int right = maxTreeNode(root.right);
        if(left>result){
            return left;
        }
        if(right>result){
            return right;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxTreeNode mx = new MaxTreeNode();
        mx.createTree();
        System.out.println(mx.maxTreeNode(mx.root));
    }

}
