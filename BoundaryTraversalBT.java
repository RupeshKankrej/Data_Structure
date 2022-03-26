package com.datastructure.code.datastructure;

import java.util.ArrayList;

public class BoundaryTraversalBT {

    // 1
    // 2 3
    // 4 5 6 7
    //
    // Traversing all of the boundary elements in anticlockwise manner:
    // The traversal be like 1 2 4 5 6 7 3
    //
    //

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

    public ArrayList<Integer> verticalOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (!isLeaf(root))
            res.add(root.data);
        addLeftBorder(root, res);
        addLeaves(root, res);
        addRightBorder(root, res);
        return res;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void addLeftBorder(TreeNode root, ArrayList<Integer> res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur))
                res.add(cur.data);
            if (cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    private void addRightBorder(TreeNode root, ArrayList<Integer> res) {
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode cur = root.right;
        while (cur != null) {
            if (!isLeaf(cur))
                temp.add(cur.data);
            if (cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    private void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null)
            addLeaves(root.left, res);
        if (root.right != null)
            addLeaves(root.right, res);
    }

    public static void main(String[] args) {
        BoundaryTraversalBT bt = new BoundaryTraversalBT();
        bt.createTree();
        ArrayList<Integer> res = bt.verticalOrderTraversal(bt.root);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }
}
