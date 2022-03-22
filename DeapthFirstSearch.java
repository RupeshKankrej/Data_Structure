package com.datastructure.code.datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class DeapthFirstSearch {

    private final int V;
    private int E;
    private final LinkedList<Integer>[] adj;

    public DeapthFirstSearch(int nodes){
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
        sb.append(V).append(" vertices, ").append(E).append(" edges.\n");
        for(int v = 0; v<V; v++){
            sb.append(v).append(": ");
            for(int w : adj[v]){
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void depthFirstSearch(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u+" ");
                for(int v: adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DeapthFirstSearch dp = new DeapthFirstSearch(5);
        dp.addNode(0,1);
        dp.addNode(1,2);
        dp.addNode(2,3);
        dp.addNode(3,0);
        dp.addNode(2,4);
        System.out.println(dp);
        dp.depthFirstSearch(0);
    }
}
