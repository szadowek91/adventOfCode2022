package pl.szadowek91.day1;

import java.util.*;

/**
 * @author PG
 */
public class Day_1_Main {

    public static void run(){
//        System.out.println(highestTotalCalories(InputData.FINAL_LIST_OF_ITEMS));
        System.out.println(threeElvesTotal(InputData.FINAL_LIST_OF_ITEMS));
    }

    private static Integer highestTotalCalories(String inputData) {

        return Arrays.stream(inputData.split("\n\n")).map(s -> Arrays.stream(s.split("\n"))
                        .map(Integer::valueOf)
                        .mapToInt(Integer::intValue)
                        .sum())
                .max(Integer::compareTo).orElse(null);
    }

    private static Integer threeElvesTotal(String inputData){
        return Arrays.stream(inputData.split("\n\n")).map(s -> Arrays.stream(s.split("\n"))
                .map(Integer::valueOf)
                .mapToInt(Integer::intValue)
                .sum())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }


    private static Integer threeElvesTotal1(String inputData){
        return Arrays.stream(inputData.split("\n\n")).map(s -> Arrays.stream(s.split("\n"))
                        .map(Integer::valueOf)
                        .reduce(0,Integer::sum))
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
