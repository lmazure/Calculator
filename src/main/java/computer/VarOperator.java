package computer;

public class VarOperator implements Operand {

    private final int level;
    private final Stack stack;

    public VarOperator(final int level,
                       final Stack stack) {
        this.level = level;
        this.stack = stack;
    }

    @Override
    public double getValue() {
        return this.stack.getIncrementValue(this.level);
    }

    @Override
    public String getDescription() {
        return this.stack.getIncrementDescription(this.level);
    }

    @Override
    public String getLatex() {
        return this.stack.getIncrementLatex(this.level);
    }


    public static String getHelp() {
        return "Push the variable of a given depth (starting at 0) on the stack";
    }
}
