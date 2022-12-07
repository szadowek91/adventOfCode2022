package pl.szadowek91.day5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author PG
 */
public class Day_5_Main {
    public static void run() {

        List<String> strings = splitStackFromInstruction(InputData.FINAL_STACK);

        Map<Integer, List<String>> stack = createStack(strings.get(0));
        List<Instruction> instructions = createInstruction(strings.get(1));

//        result1(stack, instructions);
        result2(stack, instructions);

        System.out.println("TEST");
    }

    private static void result1(Map<Integer, List<String>> stack, List<Instruction> instructions) {
        instructions.forEach(instruction -> {
            List<String> strings1 = stack.get(instruction.getFromStack());
            List<String> strings2 = stack.get(instruction.getToStack());
            for (int i = 0; i < instruction.getMoveNumberOfElements(); i++) {
                String s = strings1.get(0);
                strings2.add(0, s);
                strings1.remove(s);
            }
        });
        SortedSet<Integer> keys = new TreeSet<>(stack.keySet());
        for (Integer key : keys) {
            System.out.println(stack.get(key).get(0));
        }
    }

    private static void result2(Map<Integer, List<String>> stack, List<Instruction> instructions) {
        instructions.forEach(instruction -> {
            List<String> strings1 = stack.get(instruction.getFromStack());
            List<String> strings2 = stack.get(instruction.getToStack());

            List<String> strToMove = new ArrayList<>();

            for (int i = 0; i < instruction.getMoveNumberOfElements(); i++) {

                String s = strings1.get(0);
                strToMove.add(s);
                strings1.remove(s);
            }

            strings2.addAll(0,strToMove);

        });
        SortedSet<Integer> keys = new TreeSet<>(stack.keySet());
        for (Integer key : keys) {
            System.out.print(stack.get(key).get(0));
        }
    }

    private static Map<Integer, List<String>> createStack(String s) {
        List<String> collect = Arrays.stream(s.split("\n")).collect(Collectors.toList());
        LinkedList<String> linkedList = new LinkedList<>();
        Map<Integer, List<String>> map = new LinkedHashMap<>();

        for (String l : collect) {
            Stream<String> stringStream = Arrays.stream(l.split(""));
            List<String> collect1 = stringStream.collect(Collectors.toList());
            for (int i = 1; i < collect1.size(); i += 4) {
                if (!collect1.get(i).trim().isEmpty()) {
                    String s1 = collect1.get(i);
                    List<String> strings = map.computeIfAbsent(i, k -> new ArrayList<>());
                    strings.add(s1);
                }
            }
        }
        Map<Integer, List<String>> remapped = new LinkedHashMap<>();
        map.forEach((k, v) -> remapped.put(Integer.valueOf(v.get(v.size() - 1)), v.subList(0, v.size() - 1)));

        return remapped;
    }

    private static List<Instruction> createInstruction(String s) {

        List<String> collect = Arrays.stream(s.split("\n")).collect(Collectors.toList());
        List<Instruction> instructions = new ArrayList<>();

        List<String[]> collect2 = collect.stream().map(i -> i.split(" ")).collect(Collectors.toList());

        List<Instruction> instructionList = collect2.stream()
                .map(instr -> new Instruction(Integer.parseInt(instr[1]), Integer.parseInt(instr[3]), Integer.parseInt(instr[5]))).collect(Collectors.toList());

        return instructionList;
    }


    private static List<String> splitStackFromInstruction(String input) {
        List<String> collect = Arrays.stream(input.split("\n\n")).collect(Collectors.toList());
        return collect;
    }
}
