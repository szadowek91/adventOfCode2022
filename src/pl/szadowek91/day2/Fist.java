package pl.szadowek91.day2;

import java.util.Arrays;

/**
 * @author PG
 */
public enum Fist {

    ROCK ("A","X",1,"SCISSORS", "PAPER"),
    PAPER ("B","Y",2, "ROCK", "SCISSORS"),
    SCISSORS ("C","Z",3, "PAPER", "ROCK");


    private final String p1choice;
    private final String p2choice;
    private final int points;
    private final String winWith;
    private final String looseWith;

    Fist(String p1choice, String p2choice, int points, String winWith, String looseWith) {
        this.p1choice = p1choice;
        this.p2choice = p2choice;
        this.points = points;
        this.winWith = winWith;
        this.looseWith = looseWith;
    }

    public static Fist selectFist(String selectedLetter){
        return Arrays.stream(Fist.values())
                .filter(s -> s.p1choice.equalsIgnoreCase(selectedLetter) || s.p2choice.equalsIgnoreCase(selectedLetter))
                .findFirst()
                .get();
    }

    public static Fist selectFist_part2(String name){
        return Fist.valueOf(name);
    }

    public String getP1choice() {
        return p1choice;
    }

    public String getP2choice() {
        return p2choice;
    }

    public int getPoints() {
        return points;
    }

    public String getWinWith() {
        return winWith;
    }

    public String getLooseWith() {
        return looseWith;
    }

    public boolean equals_my(String p1) {
        return this.name().equalsIgnoreCase(p1);

    }

}
