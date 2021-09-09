package computer;

public class RecVarOperator implements Operand {


    private final int level;
    private final IncrementStack incrementStack;

    public RecVarOperator(final int level,
                          final IncrementStack incrementStack) {
        this.level = level;
        this.incrementStack = incrementStack;
    }

    @Override
    public double getValue() {
        return this.incrementStack.getRecursionValue(this.level);
    }

    @Override
    public String getDescription() {
        return "recvar " + this.level;
    }

    @Override
    public String getLatex() {
        return this.incrementStack.getRecursionLatex(this.level);
    }

    public static String getHelp() {
        return "Push the recursion value of a given depth (starting at 0) on the stack";
    }
}
