package com.datastructure.code.datastructure;

import java.util.Stack;

public class PreOrderTraversal {

    private TreeNode root;

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

//    PreOrder using Recursion method:
    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

//    PreOrder using Iteration method:
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        PreOrderTraversal po = new PreOrderTraversal();
        po.createTree();
        System.out.println("PreOrder Traversal using Recursion: ");
        po.preOrderTraversal(po.root);
        System.out.println("\nPreOrder Traversal using Iteration: ");
        po.preOrder(po.root);
    }
}
