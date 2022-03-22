package com.datastructure.code.datastructure;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] a){
        int n = a.length;
        for(int i = 0; i<n; i++){
            int temp = a[i];
            int j = i-1;
            while(j>=0 && a[j]>temp){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] num = {23,43,1,54,22,4,76,87,8};
        System.out.println(Arrays.toString(num));
        is.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
