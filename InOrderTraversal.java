package com.datastructure;

import java.util.Stack;

public class InOrderTraversal {

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

    public void InOrderByR(TreeNode root){
        if(root == null){
            return;
        }
        InOrderByR(root.left);
        System.out.print(root.data+" ");
        InOrderByR(root.right);
    }

    public void InOrderByI(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty()|| temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    public static void main(String[] args) {
        InOrderTraversal io = new InOrderTraversal();
        io.createTree();
        io.InOrderByR(io.root);
        System.out.println();
        io.InOrderByI(io.root);
    }
}
