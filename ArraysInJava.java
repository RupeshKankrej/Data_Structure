package com.datastructure.code.datastructure;

public class ArraysInJava {

    public static void printArray(int[] arr){
        for(int e: arr){
            System.out.print(e + " ");
        }
    }

    public static void reverseArray(int[] arr){
//        int n = arr.length;
//        int[] arr1 = new int[n];
//        for(int i = 0; i < n ;i++){
//            arr1[i] = arr[(n-1) -i];
//        }
//        printArray(arr1);
        int start = 0;
        int end = arr.length -1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end --;
        }
        printArray(arr);
    }

    public static void minOfArray(int[] arr){
        int min = arr[0];
        for (int i = 0; i<arr.length;i++) {
            if(arr[i] <min){
                min = arr[i];
            }
        }
        System.out.println("\n"+min);
    }

    public static void main(String[] args) {
        int[] myArray = new int[5];
        myArray[0] = 4;
        myArray[1] = 14;
        myArray[2] = 35;
        myArray[3] = 9;
        myArray[4] = 80;
        printArray(myArray);
        System.out.println();
        reverseArray(myArray);
        minOfArray(myArray);
    }
}
