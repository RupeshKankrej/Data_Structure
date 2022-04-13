package com.datastructure.code.datastructure;

public class SymmetricBT {
    private TreeNode root;

    private static class TreeNode{
        private final int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(2);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(4);
        TreeNode sixth = new TreeNode(4);
        TreeNode seventh = new TreeNode(3);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public boolean isSymmetric(TreeNode root){
        return root==null || isSymmetricBT(root.left, root.right);
    }

    public boolean isSymmetricBT(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.data!=right.data) return false;

        return isSymmetricBT(left.left, right.right) && isSymmetricBT(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricBT bt = new SymmetricBT();
        bt.createTree();
        if(bt.isSymmetric(bt.root)){
            System.out.println("Given binary tree is symmetric.");
        }else{
            System.out.println("Given binary tree is not symmetric.");
        }
    }
}
