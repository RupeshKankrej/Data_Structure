package com.datastructure.code.datastructure;

import java.util.*;

public class DictionaryInJava {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> phoneBook = new HashMap<String,Integer>();
        int t = sc.nextInt();
        while(t-->0){
            String name = sc.next();
            int number = sc.nextInt();
            sc.nextLine();
            phoneBook.put(name, number);
        }
        while(sc.hasNext()){
            String s = sc.next();
            if(phoneBook.containsKey(s)){
                System.out.println(s+"="+phoneBook.get(s));
            }
            else{
                System.out.println("Not found");
            }
        }
    }
}
