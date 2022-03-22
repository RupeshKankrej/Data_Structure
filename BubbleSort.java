package com.datastructure.code.datastructure;

public class BubbleSort {

    public void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSwap;
        for(int i = 0; i<n-1; i++){
            isSwap = false;
            for(int j = 0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap) break;
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] num = {23,45,76,34,23,5};
        bs.bubbleSort(num);
        for (int e:num) {
            System.out.print(e+" ");
        }
    }
}
