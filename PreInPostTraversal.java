package com.datastructure.code.datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class PreInPostTraversal {

    private static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

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

    public void preInPostOrder(TreeNode root){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> post = new LinkedList<>();
        while(!stack.isEmpty()){
            Pair it = stack.pop();
            if(it.num==1){
                pre.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.left!=null){
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.num==2){
                in.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.right!=null){
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else{
                post.add(it.node.data);
            }
        }
        System.out.println("PreOrder Traversal");
        for(Integer e:pre){
            System.out.print(e+" ");
        }
        System.out.println("\nInorder Traversal");
        for(Integer e:in){
            System.out.print(e+" ");
        }
        System.out.println("\nPostorder Traversal");
        for(Integer e:post){
            System.out.print(e+" ");
        }
    }

    public static void main(String[] args) {
        PreInPostTraversal lo = new PreInPostTraversal();
        lo.createTree();
        lo.preInPostOrder(lo.root);
    }
}
