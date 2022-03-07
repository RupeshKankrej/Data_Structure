package com.datastructure;

public class ArrayZeroAtEnd {

    public void printArray(int[] arr){
        for (int e:arr) {
            System.out.print(e +" ");
        }
        System.out.println();
    }

    public void zeroAtEnd(int[] arr){
        int j = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]!= 0 && arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayZeroAtEnd ar = new ArrayZeroAtEnd();
        int[] myArray = {23,0,0,34,54,66,7,0};
        ar.printArray(myArray);
        ar.zeroAtEnd(myArray);
        ar.printArray(myArray);
    }
}
