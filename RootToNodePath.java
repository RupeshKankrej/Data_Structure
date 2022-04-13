package com.datastructure.code.datastructure;

import java.util.ArrayList;

public class RootToNodePath {
//    Returning the path from root to given node.
//    The node can be a leaf as well as any other node.
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

    public ArrayList<Integer> solve(TreeNode A, int b){
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null) return ans;
        getPath(A, ans, b);
        return ans;
    }

    private boolean getPath(TreeNode root, ArrayList<Integer> ans, int b){
        if(root==null){
            return false;
        }
        ans.add(root.data);
        if(root.data == b){
            return true;
        }
        if(getPath(root.left, ans, b) || getPath(root.right, ans, b)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    public static void main(String[] args) {
        RootToNodePath rt = new RootToNodePath();
        rt.createTree();
        ArrayList<Integer> ans = rt.solve(rt.root, 7);
        for(int e: ans){
            System.out.print(e+" ");
        }
        System.out.println();
    }

}
