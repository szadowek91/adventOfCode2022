package pl.szadowek91.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PG
 */
public class Day_10_Main {

    public static void run() {
        String example = InputData.FINAL_CYCLE;
        part_1(example);
    }

    public static void part_1(String input) {
        int registerX = 1;
        int currentProcessorCycle = 0;
        int cycle_20 = 0;
        int cycle_60 = 0;
        int cycle_100 = 0;
        int cycle_140 = 0;
        int cycle_180 = 0;
        int cycle_220 = 0;

        List<String> collect = Arrays.stream(input.split("\n")).collect(Collectors.toList());
        System.out.println("TEST");
        for (String singleInstruction : collect) {
            if(currentProcessorCycle == 218){
                System.out.println("TEST");
            }
            if (singleInstruction.equals("noop")) {
                currentProcessorCycle += 1;

                if (currentProcessorCycle == 20) {
                    cycle_20 = (20 * registerX);
                } else if (currentProcessorCycle == 60) {
                    cycle_60 = (60 * registerX);
                } else if (currentProcessorCycle == 100) {
                    cycle_100 = (100 * registerX);
                } else if (currentProcessorCycle == 140) {
                    cycle_140 = (140 * registerX);
                } else if (currentProcessorCycle == 180) {
                    cycle_180 = (180 * registerX);
                } else if (currentProcessorCycle == 220) {
                    cycle_220 = (220 * registerX);
                } else if (currentProcessorCycle > 220) {
                    break;
                }
            } else {
                List<String> collect1 = Arrays.stream(singleInstruction.split(" ")).collect(Collectors.toList());
                String s = collect1.get(1);
                int integer = Integer.parseInt(s);
                for (int i = 0; i <2; i++) {
                    if (i ==0) {
                        currentProcessorCycle += 1;

                        if (currentProcessorCycle == 20) {
                            cycle_20 = (20 * registerX);
                        } else if (currentProcessorCycle == 60) {
                            cycle_60 = (60 * registerX);
                        } else if (currentProcessorCycle == 100) {
                            cycle_100 = (100 * registerX);
                        } else if (currentProcessorCycle == 140) {
                            cycle_140 = (140 * registerX);
                        } else if (currentProcessorCycle == 180) {
                            cycle_180 = (180 * registerX);
                        } else if (currentProcessorCycle == 220) {
                            cycle_220 = (220 * registerX);
                        } else if (currentProcessorCycle > 220) {
                            break;
                        }
                    } else {
                        currentProcessorCycle+=1;

                        if (currentProcessorCycle == 20) {
                            cycle_20 = (20 * registerX);
                        } else if (currentProcessorCycle == 60) {
                            cycle_60 = (60 * registerX);
                        } else if (currentProcessorCycle == 100) {
                            cycle_100 = (100 * registerX);
                        } else if (currentProcessorCycle == 140) {
                            cycle_140 = (140 * registerX);
                        } else if (currentProcessorCycle == 180) {
                            cycle_180 = (180 * registerX);
                        } else if (currentProcessorCycle == 220) {
                            cycle_220 = (220 * registerX);
                        } else if (currentProcessorCycle > 220) {
                            break;
                        }
                        registerX += integer;
                    }
                }
            }

            if (currentProcessorCycle > 220){
                break;
            }
        }
        int total
                = cycle_20
                + cycle_60
                + cycle_100
                + cycle_140
                + cycle_180
                + cycle_220;

        System.out.println(total);
        System.out.println("TEST");
    }
}
