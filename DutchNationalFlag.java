package com.datastructure;

import java.util.Arrays;

public class DutchNationalFlag {

    public void dutchAlgo(int[] a){
        int i = 0;
        int j = 0;
        int k = a.length-1;
        while(i<=k){
            if(a[i]==0){
                swap(a, i, j);
                i++;
                j++;
            }
            else if (a[i] == 1){
                i++;
            }
            else if(a[i] == 2){
                swap(a, i, k);
                k--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,0,2,1,0,0,2,0,1,1,1,2,0,1,2};
        DutchNationalFlag df = new DutchNationalFlag();
        System.out.println(Arrays.toString(a));
        df.dutchAlgo(a);
        System.out.println(Arrays.toString(a));
    }
}
