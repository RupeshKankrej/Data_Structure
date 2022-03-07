package com.datastructure;

public class TreeImpleByAdjMat {

    private int V;
    private int E;
    private int[][] adjMatrix;

    public TreeImpleByAdjMat(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addNode(int v, int u){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V+" vertices, "+E+" edges "+"\n");
        for(int i = 0; i<V; i++){
            sb.append(V +": ");
            for(int e : adjMatrix[i]){
                sb.append(e+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeImpleByAdjMat tree = new TreeImpleByAdjMat(4);
        tree.addNode(0,1);
        tree.addNode(1,2);
        tree.addNode(2,3);
        tree.addNode(3,0);
        System.out.println(tree);
    }
}
