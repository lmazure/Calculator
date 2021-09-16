package computer;

import java.util.LinkedList;

/**
 * stack of data for the loop/recursion operators
 * When such an operator is used, a new stack level is created.
 * Such a level can contain:
 * <ul>
 * <li>when evaluating an expression
 *  <ul>
 *   <li>the value of the increment of the loop/recursion operator</li>
 *   <li>the current value of the recursion (only got a recursion operator)</li>
 *  </ul></li>
 * <li>when generating the description of an expression
 *  <ul>
 *   <li>the description describing the increment</li>
 *   <li>the description describing the value of the recursion (only for a recursion operator)</li>
 *  </ul></li>
 * <li>when generating the Latex of an expression
 *  <ul>
 *   <li>the latex describing the increment</li>
 *   <li>the latex describing the value of the recursion (only for a recursion operator)</li>
 *  </ul></li>
 * <ul>
 *
 */
public class Stack {

    private final LinkedList<StackElement> stack = new LinkedList<>();
    private static final int MAX_LEVEL = 10;

    public void push(final int incrementValue) {
        push(Integer.valueOf(incrementValue), null, null, null, null, null);
    }

    public void push(final int incrementValue,
                     final double recursionValue) {
        push(Integer.valueOf(incrementValue), Double.valueOf(recursionValue), null, null, null, null);
    }

    public void pushDescription(final String incrementDescription) {
        push(null, null, incrementDescription, null, null, null);
    }

    public void pushDescription(final String incrementDescription,
                                final String recursionDescription) {
        push(null, null, incrementDescription, recursionDescription, null, null);
    }

    public void pushLatex(final String incrementLatex) {
        push(null, null, null, null, incrementLatex, null);
    }

    public void pushLatex(final String incrementLatex,
                          final String recursionLatex) {
        push(null, null, null, null, incrementLatex, recursionLatex);
    }

    private void push(final Integer incrementValue,
                      final Double recursionValue,
                      final String incrementDescription,
                      final String recursionDescription,
                      final String incrementLatex,
                      final String recursionLatex) {
        if (getCurrentDepth() == MAX_LEVEL) {
            throw new TooManyLevelsException("Too many levels (" + (MAX_LEVEL) + ") of nested loops");
        }
        this.stack.addLast(new StackElement(incrementValue, incrementDescription, incrementLatex, recursionValue, recursionDescription, recursionLatex));
    }

    public void discardTop() {
        this.stack.removeLast();
    }

    public int getIncrementValue(final int depth) {
        return this.stack.get(depth).getIncrementValue().intValue();
    }

    public String getIncrementDescription(final int depth) {
        return this.stack.get(depth).getIncrementDescription();
    }

    public String getIncrementLatex(final int depth) {
        return this.stack.get(depth).getIncrementLatext();
    }

    public double getRecursionValue(final int depth) {
        final Double d = this.stack.get(depth).getRecursionValue();
        if (d == null) {
            throw new BadDepthException("There is no recursion value for depth " + depth);
        }
        return d.doubleValue();
    }

    public String getRecursionDescription(final int depth) {
        final String s = this.stack.get(depth).getRecursionDescription();
        if (s == null) {
            throw new BadDepthException("There is no recursion description for depth " + depth);
        }
        return s;
    }

    public String getRecursionLatex(final int depth) {
        final String s = this.stack.get(depth).getRecursionLatext();
        if (s == null) {
            throw new BadDepthException("There is no recursion latex for depth " + depth);
        }
        return s;
    }

    /**
     * @return current stack depth (starting at 0, so return -1 if the stack is empty)
     */
    public int getCurrentDepth() {
        return this.stack.size() - 1;
    }
    
    private class StackElement {

        final private Integer incrementValue;
        final private String incrementDescription;
        final private String incrementLatext;
        final private Double recursionValue;
        final private String recursionDescription;
        final private String recursionLatext;

        public StackElement(final Integer incrementValue,
                            final String incrementDescription,
                            final String incrementLatext,
                            final Double recursionValue,
                            final String recursionDescription,
                            final String recursionLatext) {
            super();
            this.incrementValue = incrementValue;
            this.incrementDescription = incrementDescription;
            this.incrementLatext = incrementLatext;
            this.recursionValue = recursionValue;
            this.recursionDescription = recursionDescription;
            this.recursionLatext = recursionLatext;
        }

        public Integer getIncrementValue() {
            return this.incrementValue;
        }

        public String getIncrementDescription() {
            return this.incrementDescription;
        }

        public String getIncrementLatext() {
            return this.incrementLatext;
        }

        public Double getRecursionValue() {
            return this.recursionValue;
        }

        public String getRecursionDescription() {
            return this.recursionDescription;
        }

        public String getRecursionLatext() {
            return this.recursionLatext;
        }
    }
}
