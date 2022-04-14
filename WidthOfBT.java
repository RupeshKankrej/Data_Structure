package com.datastructure.code.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT {
//    To find the width of binary tree

    private TreeNode root;

    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode _node, int _index){
            this.node = _node;
            this.index = _index;
        }
    }

    private static class TreeNode {
        private final int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        TreeNode eighth = new TreeNode(7);
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        seventh.right = eighth;
    }

    public int widthOfBinaryTree(TreeNode root){
        if(root==null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            int min = queue.peek().index;
            int size = queue.size();
            int first = 0, last = 0;
            for(int i = 0; i<size; i++){
                int curIndex = queue.peek().index - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0) first = curIndex;
                if(i==size-1) last = curIndex;
                if(node.left!=null) queue.offer(new Pair(node.left, curIndex*2+1));
                if(node.right!=null) queue.offer(new Pair(node.right, curIndex*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        WidthOfBT bt = new WidthOfBT();
        bt.createTree();
        System.out.println(bt.widthOfBinaryTree(bt.root));
    }
}
