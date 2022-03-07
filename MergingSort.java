package com.datastructure;

import java.util.Arrays;

public class MergingSort {

    public void sort(int[] a, int[] temp, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;
            sort(a, temp, low, mid);
            sort(a, temp, mid+1, high);
            merge(a, temp, low, mid, high);
        }
    }

    private void merge(int[] a, int[] temp, int low, int mid, int high) {
        for(int i = low; i<=high; i++){
            temp[i] = a[i];
        }
        int i = low; int j = mid+1; int k = low;
        while(i<=mid && j<=high){
            if(temp[i] <temp[j]){
                a[k] = temp[i];
                i++;
            }
            else{
                a[k] = temp[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            a[k] = temp[i];
            i++; k++;
        }
    }

    public static void main(String[] args) {
        MergingSort mg = new MergingSort();
        int[] a = {25,80,1,54,65,40,13,92,41,82,72};
        int[] temp = new int[a.length];
        System.out.println(Arrays.toString(a));
        mg.sort(a, temp, 0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
