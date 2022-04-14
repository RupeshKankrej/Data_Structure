package com.datastructure.code.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class SumPropertyBT {
    private TreeNode root;

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createTree() {
        TreeNode first = new TreeNode(40);
        TreeNode second = new TreeNode(10);
        TreeNode third = new TreeNode(20);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(30);
        TreeNode seventh = new TreeNode(40);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public void sumProperty(TreeNode root){
        if(root==null){
            return;
        }
        int child = 0;
        if(root.left!=null) child+=root.left.data;
        if(root.right!=null) child+=root.right.data;

        if(child<root.data){
            if(root.left!=null) root.left.data = root.data;
            if(root.right!=null) root.right.data = root.data;
        }
        else{
            root.data = child;
        }
        sumProperty(root.left);
        sumProperty(root.right);
        int tot = 0;
        if(root.left!=null) tot +=root.left.data;
        if(root.right!=null) tot+=root.right.data;
        if(root.left!=null || root.right!=null) root.data = tot;
    }

    public void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        SumPropertyBT bt = new SumPropertyBT();
        bt.createTree();
        bt.sumProperty(bt.root);
        bt.levelOrderTraversal(bt.root);
    }

}
