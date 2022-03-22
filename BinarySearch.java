package com.datastructure.code.datastructure;

public class BinarySearch {

    public int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(arr[mid] == key) return mid;
            if(key<arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] num = {32,37,45,58,66,78,99};
        System.out.println(bs.binarySearch(num, 45));
        System.out.println(bs.binarySearch(num, 78));
        System.out.println(bs.binarySearch(num, 98));

    }
}
