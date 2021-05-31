package computer;

public class Logarithm extends UnaryOperator {
    protected Logarithm(final Operand o1) {
        super(o1);
    }

    @Override
    public double getValue() {
        return Math.log(o1.getValue());
    }

    @Override
    public String getDescription() {
        return "ln(" + o1.getDescription() + ")";
    }
}