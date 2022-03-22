package com.datastructure.code.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HourglassSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int maxSum = -64;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                int sumTop = arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2);

                int sumBottom = arr.get(i+1).get(j+1);

                int sumDown = arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
                int sumTemp = sumTop+sumBottom+sumDown;
                if(sumTemp>maxSum){
                    maxSum = sumTemp;
                }
            }

        }
        System.out.println(maxSum);
    }
}
