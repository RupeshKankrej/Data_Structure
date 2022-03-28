package com.datastructure.code.datastructure;

import java.util.*;
import java.util.Queue;

public class TopViewBT {
    // For top view of BST
    // we will be considering first element of each column
    // | | | | |
    // 1
    // / \
    // 2 3
    // / \ \
    // 4 6 7
    //
    // Top view of above tree is : 4 2 1 3 7
    // When there is overlying we will be taking the topmost element of that column

    private TreeNode root;

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
        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
    }

    public static class Pair {
        int hd;
        TreeNode node;

        Pair(int _hd, TreeNode _node) {
            this.hd = _hd;
            this.node = _node;
        }
    }

    public ArrayList<Integer> verticalTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while(!queue.isEmpty()){
            Pair t = queue.remove();
            int hd = t.hd;
            TreeNode node = t.node;
            if(!map.containsKey(hd)) map.put(hd, node.data);
            if(node.left!=null) queue.add(new Pair(hd-1, node.left));
            if(node.right!=null) queue.add(new Pair(hd+1, node.right));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        TopViewBT tp = new TopViewBT();
        tp.createTree();
        ArrayList<Integer> ar = tp.verticalTraversal(tp.root);
        for(Integer e: ar){
            System.out.print(e+" ");
        }
    }
}
