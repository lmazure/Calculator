package computer;

import java.util.function.Function;

abstract class SimpleUnaryOperator extends UnaryOperator {

    private final Function<Double, Double> function;
    private final String prefix;
    private final String suffix;

    protected SimpleUnaryOperator(final Operand o1,
                                  final Function<Double, Double> function,
                                  final String prefix,
                                  final String suffix) {
        super(o1);
        this.function = function;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public double getValue() {
        return this.function.apply(Double.valueOf(this.o1.getValue())).doubleValue();
    }

    @Override
    public String getDescription() {
        return this.prefix + this.o1.getDescription() + this.suffix;
    }
}
