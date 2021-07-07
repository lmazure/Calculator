package computer;

import java.util.function.DoubleBinaryOperator;

abstract public class LoopOperator implements Operand {

    private final Operand o1;
    private final Operand o2;
    private final Operand o3;
    private final IncrementStack incrementStack;
    private final double initialValue;
    private final DoubleBinaryOperator operator;
    private final String description;
    private final String latex;

    public LoopOperator(final Operand o1,
                        final Operand o2,
                        final Operand o3,
                        final IncrementStack incrementStack,
                        final double initialValue,
                        final DoubleBinaryOperator operator,
                        final String description,
                        final String latex) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.description = description;
        this.initialValue = initialValue;
        this.operator = operator;
        this.latex = latex;
        this.incrementStack = incrementStack;
    }

    @Override
    public double getValue() {
        final int min = (int) Math.round(this.o1.getValue());
        final int max = (int) Math.round(this.o2.getValue());
        if (max < min) {
            throw new BadBoundsException("Bad bounds (min=" + min + " , max=" + max + ")");
        }
        double result = this.initialValue;
        for (int i = min ; i <= max; i++) {
            this.incrementStack.push(i);
            result = operator.applyAsDouble(result, this.o3.getValue());
            this.incrementStack.discardTop();
        }
        return result;
    }

    @Override
    public String getDescription() {
        final String name = this.incrementStack.getNameOfTop();
        this.incrementStack.push(0);
        final String description = this.description + " for " + name + " equal " + this.o1.getDescription() + " to " + this.o2.getDescription() + " of { " + this.o3.getDescription() + " }";
        this.incrementStack.discardTop();
        return description;
    }

    @Override
    public String getLatex() {
        final String name = this.incrementStack.getNameOfTop();
        this.incrementStack.push(0);
        final String latex = "\\" + this.latex+ "_{" + name + "=" + this.o1.getLatex() + "}^{" + name + "=" + this.o2.getLatex() + "}" + this.o3.getLatex();
        this.incrementStack.discardTop();
        return latex;
    }
}
