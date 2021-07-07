package computer;

public class SumOperator implements Operand {

    private final Operand o1;
    private final Operand o2;
    private final Operand o3;
    private final IncrementStack incrementStack;

    public SumOperator(final Operand o1,
                       final Operand o2,
                       final Operand o3,
                       final IncrementStack varStack) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.incrementStack = varStack;
    }

    @Override
    public double getValue() {
        final int min = (int) Math.round(o1.getValue());
        final int max = (int) Math.round(o2.getValue());
        // TODO check that min <= max, throw error otherwise
        double sum = 0;
        for (int i = min ; i <= max; i++) {
            this.incrementStack.push(i);
            sum += o3.getValue();
            this.incrementStack.discardTop();
        }
        return sum;
    }

    @Override
    public String getDescription() {
        final String name = this.incrementStack.getNameOfTop();
        this.incrementStack.push(0);
        final String description = "sum for " + name + " equal " + o1.getDescription() + " to " + o2.getDescription() + " of { " + o3.getDescription() + " }";
        this.incrementStack.discardTop();
        return description;
    }

    @Override
    public String getLatex() {
        final String name = this.incrementStack.getNameOfTop();
        this.incrementStack.push(0);
        final String latex = "\\sum_{" + name + "=" + o1.getLatex() + "}^{" + name + "=" + o2.getLatex() + "}" + o3.getLatex();
        this.incrementStack.discardTop();
        return latex;
    }
}
