package com.datastructure.code.datastructure;

import java.util.LinkedList;

public class TreeImpleByAdjList {

    private final int V;
    private int E;
    private final LinkedList[] adj;

    public TreeImpleByAdjList(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int i = 0; i<V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addNode(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append("\n");
        for(int i = 0; i<V; i++){
            sb.append(i).append(": ");
            for(Object w: adj[i]){
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeImpleByAdjList tree= new TreeImpleByAdjList(4);
        tree.addNode(0,1);
        tree.addNode(1,2);
        tree.addNode(2,3);
        tree.addNode(3,0);
        System.out.println(tree);
    }
}
