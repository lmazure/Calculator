package computer;

import java.util.LinkedList;

/**
 * stack of data for the loop/recursion operators
 * When such an operator is used, a new stack level is created.
 * Such a level can contain:
 * <ul>
 * <li>when evaluating an expressions
 *  <ul>
 *   <li>the value of the increment of the loop/recursion operator</li>
 *   <li>the current value of the recursion (only got a recursion operator)</li>
 *  </ul></li>
 * <li>when generating the Latex of an expression
 *  <ul>
 *   <li>the latex expression defining the value of the recursion (only for a recursion operator)</li>
 *  </ul></li>
 * <ul>
 *
 */
public class Stack {

    private final LinkedList<Integer> stack = new LinkedList<>();
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
        if (this.stack.size() == MAX_LEVEL) {
            throw new TooManyLevelsException("Too many levels (" + (MAX_LEVEL + 1) + ") of nested loops");
        }
        this.stack.push(incrementValue);
        this.recursionStack.push(recursionValue);
        this.latexRecursionStack.push(recursionLatex);
    }

    public void discardTop() {
        this.stack.pop();
        this.recursionStack.pop();
        this.latexRecursionStack.pop();
    }

    public int getIncrementValue(final int level) {
        return this.stack.get(level).intValue();
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
            throw new BadDepthException("There is no recursion latex for depth " + level);
        }
        return s;
    }

    public static String getIncrementName(final int level) {
        return ""+ (char)('i' + level);
    }

    public String getIncrementNameOfTop() {
        return getIncrementName(this.stack.size());
    }
}
