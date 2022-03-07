package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeDS {
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

    public void preOrderByR(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root;
        System.out.print(root.data+" ");
        preOrderByR(root.left);
        preOrderByR(root.right);
    }

    public void preOrderByI(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrderByR(TreeNode root){
        if(root == null){
            return;
        }
        inOrderByR(root.left);
        System.out.print(root.data+" ");
        inOrderByR(root.right);
    }

    public void inOrderByI(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty()||temp!=null){
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

    public void postOrderByR(TreeNode root){
        if(root == null){
            return;
        }
        postOrderByR(root.left);
        postOrderByR(root.right);
        System.out.print(root.data+" ");
    }

    public void postOrderByI(TreeNode root){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()||current!=null){
            if(current!=null){
                stack.push(current);
                current = current.left;
            }
            else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty()&&temp==stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    current = temp;
                }
            }
        }
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

    public static void main (String[] args) {
        TreeDS tree = new TreeDS();
        tree.createTree();
        System.out.println("PreOrder traversal using Recursion method: ");
        tree.preOrderByR(tree.root);
        System.out.println("\nPreOrder traversal using Iteration method: ");
        tree.preOrderByI(tree.root);
        System.out.println("\nInOrder traversal using Recursion method: ");
        tree.inOrderByR(tree.root);
        System.out.println("\nInOrder traversal using Iteration method: ");
        tree.inOrderByI(tree.root);
        System.out.println("\nPostOrder traversal using Recursion method: ");
        tree.postOrderByR(tree.root);
        System.out.println("\nPostOrder traversal using Iteration method: ");
        tree.postOrderByI(tree.root);
        System.out.println("\nLevelOrder traversal: ");
        tree.levelOrderTraversal(tree.root);
    }
}
