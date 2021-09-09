package computer;

import java.util.LinkedList;

public class IncrementStack {

    private final LinkedList<Integer> incrementStack = new LinkedList<>();
    private final LinkedList<Double> recursionStack = new LinkedList<>();
    private final LinkedList<String> latexRecursionStack = new LinkedList<>();
    private static final int MAX_LEVEL = 10;

    public void push(final int incrementValue) {
        push(Integer.valueOf(incrementValue), null, null);
    }

    public void push(final int incrementValue,
                     final double recursionValue) {
        push(Integer.valueOf(incrementValue), Double.valueOf(recursionValue), null);
    }

    public void pushLatex(final String recursionLatex) {
        push(null, null, recursionLatex);
    }

    private void push(final Integer incrementValue,
                      final Double recursionValue,
                      final String recursionLatex) {
        if (this.incrementStack.size() == MAX_LEVEL) {
            throw new TooManyLevelsException("Too many levels (" + (MAX_LEVEL + 1) + ") of nested loops");
        }
        this.incrementStack.push(incrementValue);
        this.recursionStack.push(recursionValue);
        this.latexRecursionStack.push(recursionLatex);
    }

    public void discardTop() {
        this.incrementStack.pop();
        this.recursionStack.pop();
        this.latexRecursionStack.pop();
    }

    public int getIncrementValue(final int level) {
        return this.incrementStack.get(level).intValue();
    }

    public double getRecursionValue(final int level) {
        final Double d = this.recursionStack.get(level);
        if (d == null) {
            throw new BadDepthException("There is no recursion value for depth " + level);
        }
        return d.doubleValue();
    }

    public String getRecursionLatex(final int level) {
        final String s = this.latexRecursionStack.get(level);
        if (s == null) {
            throw new BadDepthException("There is no recursion value for depth " + level);
        }
        return s;
    }

    public static String getIncrementName(final int level) {
        return ""+ (char)('i' + level);
    }

    public String getIncrementNameOfTop() {
        return getIncrementName(this.incrementStack.size());
    }
}
