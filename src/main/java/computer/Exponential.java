package computer;

public class Exponential extends UnaryOperator {

    protected Exponential(final Operand o1) {
        super(o1);
    }

    @Override
    public double getValue() {
        return Math.exp(o1.getValue());
    }

    @Override
    public String getDescription() {
        return "e^(" + o1.getDescription() + ")";
    }
}
