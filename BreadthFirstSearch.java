package com.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public BreadthFirstSearch(int nodes){
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
        sb.append(V+" vertices, "+E+" edges"+"\n");
        for(int i = 0; i<V ; i++){
            sb.append(i+": ");
            for(int w: adj[i]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void breadFirstSearch(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(int v: adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bs = new BreadthFirstSearch(5);
        bs.addNode(0,1);
        bs.addNode(1,2);
        bs.addNode(2,3);
        bs.addNode(3,0);
        bs.addNode(2,4);
        System.out.println(bs);
        bs.breadFirstSearch(0);
    }

}
