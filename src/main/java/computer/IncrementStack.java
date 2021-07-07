package computer;

import java.util.LinkedList;

public class IncrementStack {

    private final LinkedList<Integer> stack = new LinkedList<>();
    private final int MAX_LEVEL = 10;

    public void push(final int value) {
        if (stack.size() == MAX_LEVEL) {
            throw new TooManyLevelsException("Too many levels (" + (MAX_LEVEL + 1) + ") of nested loops");
        }
        this.stack.push(Integer.valueOf(value));
    }

    public void discardTop() {
        this.stack.pop();
    }

    public int getValue(final int level) {
        return stack.get(level);
    }

    public String getName(final int level) {
        return ""+ (char)('i' + level);
    }

    public String getNameOfTop() {
        return getName(stack.size());
    }
}
