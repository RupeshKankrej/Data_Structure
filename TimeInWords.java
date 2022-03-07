package com.datastructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TimeInWords {

    public static void timeInWords(int h, int m){
        String[] time = {"o' clock", "one", "two", "three", "four", "five","six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen","twenty", "twenty one", "twenty two", "twenty three", "twenty four",
        "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half"};
        if(m == 0){
            System.out.println(time[h]+" "+time[0]);
        }
        else if(m<=30){
            System.out.println(time[m]+" past "+time[h]);
        }
        else{
            System.out.println(time[60-m]+" "+time[h+1%12]);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        timeInWords(h,m);
    }
}
