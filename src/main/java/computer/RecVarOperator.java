package computer;

public class RecVarOperator implements Operand {


    private final int level;
    private final Stack stack;

    public RecVarOperator(final int level,
                          final Stack stack) {
        this.level = level;
        this.stack = stack;
    }

    @Override
    public double getValue() {
        return this.stack.getRecursionValue(this.level);
    }

    @Override
    public String getDescription() {
        return this.stack.getRecursionDescription(this.level);
    }

    @Override
    public String getLatex() {
        return this.stack.getRecursionLatex(this.level);
    }

    public static String getHelp() {
        return "Push the recursion value of a given depth (starting at 0) on the stack";
    }
}
