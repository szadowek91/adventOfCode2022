package pl.szadowek91.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PG
 */
public class Day_3_Main {

    public static void run() {
        List<String> priorityItems = getPriorityItems_part2(InputData.FINAL_RUCKSACK);
        List<Character> points = points();
        int total = 0;

        for (String item : priorityItems) {
            int i1 = points.indexOf(item.toCharArray()[0]) + 1;
            total += i1;
        }
        System.out.println(total);
    }

    private static List<Character> points() {
        List<Character> alphabet = new ArrayList<>();
        char a = 'a';
        while (a <= 'z')
            alphabet.add(a++);
        char A = 'A';
        while (A <= 'Z')
            alphabet.add(A++);

        return alphabet;

    }

    private static List<String> getPriorityItems(String input) {

        List<String> splittedRucksacks = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        List<String> highestPriorityList = new ArrayList<>();

        for (String ruscksack : splittedRucksacks) {
            String substring_1 = "";
            String substring_2 = "";

            int halfOfRucksack = (ruscksack.length() / 2);
            substring_1 = ruscksack.substring(0, halfOfRucksack);
            substring_2 = ruscksack.substring(halfOfRucksack);

            char[] chars1 = substring_1.toCharArray();
            char[] chars2 = substring_2.toCharArray();

            boolean found = false;

            for (Character c1 : chars1) {
                if (found) break;
                for (Character c2 : chars2) {
                    if (c2.equals(c1)) {
                        highestPriorityList.add(c1.toString());
                        System.out.println(c1);
                        found = true;
                        break;
                    }
                }
            }
        }
        return highestPriorityList;
    }

    private static List<String> getPriorityItems_part2(String input) {

        List<List<String>> sortedRucksacks = new ArrayList<>();
        List<String> splittedRucksacks = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        List<String> highestPriorityList = new ArrayList<>();

        for (int i = 0; i < splittedRucksacks.size(); i++) {
            List<String> strings = splittedRucksacks.subList(i, i + 3);
            sortedRucksacks.add(strings);
            i += 2;
        }

        for (List<String> three_rucksack : sortedRucksacks) {

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            List<String> list3 = new ArrayList<>();

            for (int i = 0; i < three_rucksack.size(); i++){
                if (i == 0){
                    list1.addAll(Arrays.stream(three_rucksack.get(i).split("")).collect(Collectors.toList()));
                }
                if (i == 1){
                    list2.addAll(Arrays.stream(three_rucksack.get(i).split("")).collect(Collectors.toList()));
                }
                if (i == 2){
                    list3.addAll(Arrays.stream(three_rucksack.get(i).split("")).collect(Collectors.toList()));
                }
            }
            highestPriorityList.add(list1.stream().filter(l1 -> list2.contains(l1) && list3.contains(l1)).findFirst().get());
        }
        return highestPriorityList;
    }
}
