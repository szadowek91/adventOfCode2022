package pl.szadowek91.day4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author PG
 */
public class Day_4_Main {
    public static void run() {

        splitLines_part2(InputData.FINAL_CAMP);

    }

    private static void splitLines(String input) {
        List<String> collect = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        List<List<String>> collect1 = collect.stream().map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).collect(Collectors.toList());

        List<List<List<Integer>>> collect3 = collect1.stream()
                .map(s -> s.stream()
                        .map(d -> {
            List<Integer> collect2 = Arrays.stream(d.split("-"))
                    .mapToInt(Integer::valueOf)
                    .boxed()
                    .collect(Collectors.toList());
            return getNumbersUsingIntStreamRangeClosed(collect2.get(0), collect2.get(1));
        }).sorted(Comparator.comparing(List::size))
                .collect(Collectors.toList()))
                .filter(l -> l.get(1).containsAll(l.get(0)))
                .collect(Collectors.toList());

        int size = collect3.size();

        System.out.println(size);
    }

    private static void splitLines_part2(String input) {
        List<String> collect = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        List<List<String>> collect1 = collect.stream().map(s -> Arrays.stream(s.split(",")).collect(Collectors.toList())).collect(Collectors.toList());

        List<List<List<Integer>>> collect3 = collect1.stream()
                .map(s -> s.stream()
                        .map(d -> {
                            List<Integer> collect2 = Arrays.stream(d.split("-"))
                                    .mapToInt(Integer::valueOf)
                                    .boxed()
                                    .collect(Collectors.toList());
                            return getNumbersUsingIntStreamRangeClosed(collect2.get(0), collect2.get(1));
                        }).sorted(Comparator.comparing(List::size))
                        .collect(Collectors.toList()))
                .filter(l -> l.get(0).stream().anyMatch(d -> l.get(1).contains(d)))
                .collect(Collectors.toList());

        int size = collect3.size();

        System.out.println(size);
    }

    public static List<Integer> getNumbersUsingIntStreamRangeClosed(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

}
