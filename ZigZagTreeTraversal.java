package com.datastructure.code.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {
//    Traversing the tree in zigzag manner from root node
//            -->    1
//                 /   \
//               2      3   <--
//              / \      \
//        -->  4   5      6
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

    public LinkedList<int[]> zigZagTraversal(TreeNode root){
        LinkedList<int[]> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] row = new int[size];
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                int index = (leftToRight) ? i : size-1-i;
                row[index] = node.data;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args){
        ZigZagTreeTraversal zz = new ZigZagTreeTraversal();
        zz.createTree();
        LinkedList<int[]> ans = zz.zigZagTraversal(zz.root);
        for (int[] e:ans) {
            for(int a: e){
                System.out.print(a +" ");
            }
            System.out.println();
        }
    }
}
