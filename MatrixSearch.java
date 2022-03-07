package com.datastructure;

public class MatrixSearch {

    public void searchKey(int[][] matrix,int value){
        for(int i =0; i<4; i++){
            for(int j =0; j<4;j++){
                if(matrix[i][j]==value){
                    System.out.println("found");
                    return;
                }
            }
        }
        System.out.println("not found");
    }

    public void searchKey(int[][] matrix, int value , int n){
        int i = 0;
        int j= n-1;
        while(i<n && j>=0){
            if(matrix[i][j] == value){
                System.out.println("Element found at "+i+", "+j);
                return;
            }
            if(matrix[i][j]>value){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        MatrixSearch ma = new MatrixSearch();
        int[][] matrix = new int[4][4];
        matrix[0][0] =1; matrix[0][1]= 2; matrix[0][2]= 3; matrix[0][3]= 4;
        matrix[1][0] =5; matrix[1][1]= 6; matrix[1][2]= 7; matrix[1][3]= 8;
        matrix[2][0] =9; matrix[2][1]= 10; matrix[2][2]= 11; matrix[2][3]= 12;
        matrix[3][0] =13; matrix[3][1]= 14; matrix[3][2]= 15; matrix[3][3]= 16;
        ma.searchKey(matrix , 17);
        ma.searchKey(matrix , 16,4);
    }
}
