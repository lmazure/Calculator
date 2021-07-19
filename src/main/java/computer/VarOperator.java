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
        return this.incrementStack.getValue(this.level);
    }

    @Override
    public String getDescription() {
        return IncrementStack.getName(this.level);
    }

    @Override
    public String getLatex() {
        return IncrementStack.getName(this.level);
    }
}
