package com.datastructure.code.datastructure;

public class Array {
//    Printing the array;
    public void printArray(int[] arr){
        for(int e: arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }

//    Reversing the Array.
    public int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

//    Sending the zero to the end of the Array
    public int[] zeroAtEnd(int[] arr){
        int j= 0;
        for(int i =0; i<arr.length;i++){
            if(arr[i]!=0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
        return arr;
    }

//    Finding the minimum value in the Array.
    public int minimumValue(int[] arr){
        int min = arr[0];
        for(int e :arr){
            if(e<min){
                min = e;
            }
        }
        return min;
    }

//    Resizing the Array;
    public int[] resizeArray(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for(int i =0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

//    Checking the whether the given string is Palindrome or not;
    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        while(start<end){
            if(charArray[start] != charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main (String[] args) {
        Array pd = new Array();
        int[] myArray = {98,4,6,0,2,0,5,6,43,0};
        pd.printArray(myArray);

        myArray =pd.reverseArray(myArray);
        pd.printArray(myArray);

        myArray = pd.zeroAtEnd(myArray);
        pd.printArray(myArray);

        int[] newArray = {34,76,65,45,86};
        System.out.println("Min value is: "+pd.minimumValue(newArray));

        System.out.println("Length of newArray: "+newArray.length);
        newArray = pd.resizeArray(newArray, 12);
        System.out.println("Length of newArray after modification: "+newArray.length);

        String word = "madam";
        if(pd.isPalindrome(word)){
            System.out.println("The string is Palindrome.");
        }
        else{
            System.out.println("The string is not Palindrome");
        }
    }
}
