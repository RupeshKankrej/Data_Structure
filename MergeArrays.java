package com.datastructure.code.datastructure;

import java.util.Arrays;

public class MergeArrays {

    public int[] merge(int[] a, int[] b, int n , int m){
        int[] result = new int[n+m];
        int i = 0, j = 0, k = 0;
        while(i<n && j<n){
            if(a[i]<b[j]){
                result[k] = a[i];
                i++;
            }
            else{
                result[k] = b[j];
                j++;
            }
            k++;
        }
        while(i<n){
            result[k] = a[i];
            i++; k++;
        }
        while(j<m){
            result[k] = b[j];
            j++; k++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeArrays ma = new MergeArrays();
        int[] a = {23,44,65,76,88};
        int[] b = {12,34,55,77,84,92};
        System.out.println("a[] = "+Arrays.toString(a));
        System.out.println("b[] = "+Arrays.toString(b));
        int[] r = ma.merge(a, b, a.length, b.length);
        System.out.println("r[] = "+Arrays.toString(r));
    }
}
