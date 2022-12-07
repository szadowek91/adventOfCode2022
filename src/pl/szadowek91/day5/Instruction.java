package pl.szadowek91.day5;

/**
 * @author PG
 */
public class Instruction {

    private int moveNumberOfElements;
    private int fromStack;
    private int toStack;

    public Instruction(int moveNumberOfElements, int fromStack, int toStack) {
        this.moveNumberOfElements = moveNumberOfElements;
        this.fromStack = fromStack;
        this.toStack = toStack;
    }

    public int getMoveNumberOfElements() {
        return moveNumberOfElements;
    }

    public int getFromStack() {
        return fromStack;
    }

    public int getToStack() {
        return toStack;
    }
}
