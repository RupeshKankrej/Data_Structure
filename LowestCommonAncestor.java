package com.datastructure.code.datastructure;

public class LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null|| root==p || root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null){
            return right;
        }
        else if(right ==null){
            return left;
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lw = new LowestCommonAncestor();
        lw.createTree();
        System.out.println(lw.lowestCommonAncestor(lw.root, lw.root.left.left, lw.root.left.right).data);
    }
}
