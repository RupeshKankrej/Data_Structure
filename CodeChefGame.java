package com.datastructure.code.datastructure;

import java.util.Scanner;
public class CodeChefGame
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Si =0, Ti =0;
        int sS =0, sT =0;
        int l1=0, l2 =0;
        for(int i=0;i<N;i++)
        {
            Si = sc.nextInt();
            Ti = sc.nextInt();
            sS +=Si;
            sT +=Ti;

            if(Si>Ti&&l1<(sS-sT)){
                l1 = sS-sT;
            }
            else if(Ti>Si&&l2<(sT-sS)){
                l2 =sT-sS;
            }
        }
        if(l1>l2){
            System.out.println("1 "+l1);
        }
        else{
            System.out.println("2 "+l2);
        }
    }
}
