package pl.szadowek91.day2;


import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PG
 */
public class Day_2_Main {

    private static String p1;
    private static String p2;

    public static void run() {
        int result = 0;

        List<Pair<String, String>> pairList = Arrays.stream(InputData.FINAL_FIGHT.split("\n"))
                .map(s -> {
                    List<String> strings = Arrays.asList(s.split(" "));
                    p1 = strings.get(0);
                    p2 = strings.get(1);
                    return new Pair<>(p1, p2);
                }).collect(Collectors.toList());

        for (Pair<String, String> p : pairList) {
            result += outcomePoints_part2(p.getKey(), p.getValue());
        }
        System.out.println(result);
    }

    private static int outcomePoints(String p1, String p2){
        int result = 0;
        Fist fistOfP1 = Fist.selectFist(p1);
        Fist fistOfP2 = Fist.selectFist(p2);

        if (fistOfP1.equals(fistOfP2)){
            result = 3;
        }else if (fistOfP1.equals_my(fistOfP2.getWinWith())){
            result = 6;
        }
        return result + fistOfP2.getPoints();
    }

    private static int outcomePoints_part2(String p1, String p2){
        int result = 0;
        String myFist;
        int fistPoint = 0;
        Fist fistOfP1 = Fist.selectFist(p1);

        if (p2.equalsIgnoreCase("X")){
            myFist = fistOfP1.getWinWith();
            fistPoint = Fist.selectFist_part2(myFist).getPoints();
        } else if (p2.equalsIgnoreCase("Y")){
            myFist = fistOfP1.name();
            fistPoint = Fist.selectFist_part2(myFist).getPoints();
            result = 3;
        } else {
            myFist = fistOfP1.getLooseWith();
            fistPoint = Fist.selectFist_part2(myFist).getPoints();
            result = 6;
        }

        return result + fistPoint;
    }
}
