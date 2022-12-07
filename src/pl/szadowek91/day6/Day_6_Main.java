package pl.szadowek91.day6;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author PG
 */
public class Day_6_Main {
    public static void run() {

        int part_1 = 4;
        int part_2 = 14;

        // PART 1
        checkFourLetters(InputData.TEST_DATASTREAM_1,part_1);
        checkFourLetters(InputData.TEST_DATASTREAM_2,part_1);
        checkFourLetters(InputData.TEST_DATASTREAM_3,part_1);
        checkFourLetters(InputData.TEST_DATASTREAM_4,part_1);
        checkFourLetters(InputData.FINAL_DATASTREAM,part_1);

        // PART 2
        checkFourLetters(InputData.TEST_DATASTREAM_1,part_2);
        checkFourLetters(InputData.TEST_DATASTREAM_2,part_2);
        checkFourLetters(InputData.TEST_DATASTREAM_3,part_2);
        checkFourLetters(InputData.TEST_DATASTREAM_4,part_2);
        checkFourLetters(InputData.FINAL_DATASTREAM,part_2);

    }

    private static void checkFourLetters(String testDatastream1, Integer integer) {

        for (int i = 0; i < testDatastream1.length(); i++) {
            String substring = testDatastream1.substring(i, i+integer);
            List<String> collect = Arrays.stream(substring.split("")).collect(Collectors.toList());
            Set<String> compared = new HashSet<String>();
            compared.addAll(collect);
            if (compared.size() == integer) {
                System.out.println(i+integer);
                break;
            }
        }
    }
}
