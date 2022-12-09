package pl.szadowek91.day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author PG
 */
public class Day_8_Main {
    public static void run_part1() {

        String testMap = InputData.FINAL_MAP;

        Integer[][] treesGrid = gridStr(testMap.replace("\n", ""));

        List<Integer> summaryList = new ArrayList<>();

        for (int line = 0; line < treesGrid.length; line++) {
            Integer[] chars = treesGrid[line];
            for (int column = 0; column <chars.length ; column++){
                if (line == 3 && column == 3){
                    System.out.println("TEST");
                }
                Integer singleItem = chars[column];
                if (line==0 || column==0 || line == treesGrid.length-1 || column == chars.length-1){
                    summaryList.add(singleItem);
                }
                else {
                    boolean visibleR = isVisibleFromRight_p1(chars, column);
                    boolean visibleL = isVisibleFromLeft_p1(chars, column);
                    boolean visibleDown = isVisibleFromDown_p1(treesGrid, column, singleItem, line);
                    boolean visibleUp = isVisibleFromUp_p1(treesGrid, column, singleItem, line);
                    if( visibleR || visibleL || visibleDown || visibleUp){
                        summaryList.add(singleItem);
                    }
                }
            }
        }
        int result = summaryList.size();
        System.out.println(result);

    }

    public static void run_part2() {

        String testMap = InputData.FINAL_MAP;

        Integer[][] treesGrid = gridStr(testMap.replace("\n", ""));

        List<Integer> summaryList = new ArrayList<>();

        for (int line = 0; line < treesGrid.length; line++) {
            Integer[] chars = treesGrid[line];
            for (int column = 0; column <chars.length ; column++){
                if (line == 1 && column == 2){
                    System.out.println("TEST");
                }
                Integer singleItem = chars[column];
                if (line==0 || column==0 || line == treesGrid.length-1 || column == chars.length-1){
                }
                else {
                    int visibleR = isVisibleFromRight_p2(chars, column);
                    int visibleL = isVisibleFromLeft_p2(chars, column);
                    int visibleDown = isVisibleFromDown_p2(treesGrid, column, singleItem, line);
                    int visibleUp = isVisibleFromUp_p2(treesGrid, column, singleItem, line);

                    int multiplied = visibleL * visibleR * visibleDown * visibleUp;
                    System.out.println(multiplied + " = " + visibleL + "*" + visibleR + "*" + visibleDown + "*" + visibleUp);
                    summaryList.add(multiplied);
                }
            }
        }
        Integer integer = summaryList.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(summaryList);
        System.out.println(integer);

    }

    private static int isVisibleFromUp_p2(Integer[][] treesGrid, int column, Integer singleItem, int line) {
        int counter = 0;
        for (int z = line-1 ; z>=0; z--) {
            Integer integer = treesGrid[z][column];
            if (integer >= singleItem){
                return counter+1;
            }
            counter++;
        }
        return counter;
    }

    private static int isVisibleFromDown_p2(Integer[][] treesGrid, int column, Integer singleItem, int line) {
        int counter = 0;
        for (int z = line+1 ; z<treesGrid.length; z++) {
            Integer integer = treesGrid[z][column];
            if (integer >= singleItem){
                return counter+1;
            }
            counter++;
        }
        return counter;
    }

    private static int isVisibleFromLeft_p2(Integer[] chars, int column) {
        int counter = 0;
        for (int z = column -1; z>= 0; z-- ){
                if (chars[z] >= chars[column]){
                    return counter+1;
                }
                counter++;
        }
        return counter;
    }

    private static int isVisibleFromRight_p2(Integer[] chars, int column) {
        int counter = 0;
        for (int z = column +1; z< chars.length; z++ ){
            if (chars[z] >= chars[column]){
                return counter+1;
            }
            counter++;
        }
        return counter;
    }


    private static boolean isVisibleFromDown_p1(Integer[][] chars, int column, Integer singleItem, int line) {
        for (int z = line+1 ; z<chars.length; z++) {
            Integer integer = chars[z][column];
            if (integer >= singleItem){
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromUp_p1(Integer[][] chars, int column, Integer singleItem, int line) {
        for (int z = line-1 ; z>=0; z--) {
            Integer integer = chars[z][column];
            if (integer >= singleItem){
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromRight_p1(Integer[] chars, int j) {
        for (int z = j +1; z< chars.length; z++ ){
            if (chars[z] >= chars[j]){
                return false;
            }
        }
        return true;
    }

    private static boolean isVisibleFromLeft_p1(Integer[] chars, int j) {
        for (int z = j -1; z>= 0; z-- ){
            if ( z>-1){
            if (chars[z] >= chars[j]){
                return false;
            }
            } else {
                break;
            }
        }
        return true;
    }

    static Integer[][] gridStr(String str)
    {
        int l = str.length();
        int k = 0, row, column;
        row = (int) Math.floor(Math.sqrt(l));
        column = (int) Math.ceil(Math.sqrt(l));

        if (row * column < l)
        {
            row = column;
        }

        Integer[][] s = new Integer[row][column];

        // convert the string into grid
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if(k < str.length())
                    s[i][j] = Integer.parseInt(String.valueOf(str.charAt(k)));
                k++;
            }
        }

        // Printing the grid
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                System.out.print(s[i][j]);
            }
            System.out.println("");
        }

        return s;
    }
}
