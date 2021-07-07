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
        return this.incrementStack.getValue(level);
    }

    @Override
    public String getDescription() {
        return this.incrementStack.getName(level);
    }

    @Override
    public String getLatex() {
        return this.incrementStack.getName(level);
    }
}
