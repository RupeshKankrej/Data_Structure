package com.datastructure;

import java.util.Scanner;

class MyRegex {
    String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
}

public class IpComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ip = sc.next();
            System.out.println(ip.matches(new MyRegex().pattern));
        }
    }

}
