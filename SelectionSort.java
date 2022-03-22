package com.datastructure.code.datastructure;

import java.util.Arrays;

public class SelectionSort {

//    public void sort(int[] a){
//        int n = a.length;
//        boolean isSwapped = false;
//        for(int i = 0; i<n; i++){
//            for(int j = i; j<n; j++){
//                if(a[j]<a[i]){
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped){
//                break;
//            }
//        }
//    }

    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] num = {12,3,54,1,65,34,9,65};
        System.out.println(Arrays.toString(num));
        ss.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
