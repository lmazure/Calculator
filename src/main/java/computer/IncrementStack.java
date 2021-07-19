package computer;

import java.util.LinkedList;

public class IncrementStack {

    private final LinkedList<Integer> stack = new LinkedList<>();
    private static final int MAX_LEVEL = 10;

    public void push(final int value) {
        if (this.stack.size() == MAX_LEVEL) {
            throw new TooManyLevelsException("Too many levels (" + (MAX_LEVEL + 1) + ") of nested loops");
        }
        this.stack.push(Integer.valueOf(value));
    }

    public void discardTop() {
        this.stack.pop();
    }

    public int getValue(final int level) {
        return this.stack.get(level).intValue();
    }

    public static String getName(final int level) {
        return ""+ (char)('i' + level);
    }

    public String getNameOfTop() {
        return getName(this.stack.size());
    }
}
