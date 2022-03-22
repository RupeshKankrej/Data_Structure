package com.datastructure.code.datastructure;

public class ResizeArray {

    public void printArray(int[] arr){
        for (int e: arr) {
            System.out.print(e+" ");
        }
        System.out.println();
    }

    public int[] resizeArray(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for(int i = 0;i< arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static void main(String[] args) {
        ResizeArray rs = new ResizeArray();
        int[] myArray = {23,5,7,5,87};
        rs.printArray(myArray);
        myArray =rs.resizeArray(myArray, 10);
        System.out.println(myArray.length);
        rs.printArray(myArray);
    }
}
