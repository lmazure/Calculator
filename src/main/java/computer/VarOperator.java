package computer;

public class VarOperator implements Operand {

    private final int level;
    private final IncrementStack incrementStack;

    public VarOperator(final int level,
                       final IncrementStack incrementStack) {
        this.level = level;
        this.incrementStack = incrementStack;
    }

    @Override
    public double getValue() {
        return this.incrementStack.getIncrementValue(this.level);
    }

    @Override
    public String getDescription() {
        return IncrementStack.getIncrementName(this.level);
    }

    @Override
    public String getLatex() {
        return IncrementStack.getIncrementName(this.level);
    }


    public static String getHelp() {
        return "Push the variable of a given depth (starting at 0) on the stack";
    }
}
