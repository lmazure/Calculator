package computer;

public class AtanhOperator extends SimpleUnaryOperator {

    public AtanhOperator(final Operand o1) {
        super(o1, AtanhOperator::atanh, "arctanh(", ")");
    }

    private static Double atanh(final Double value) {
        return 0.5d * Math.log((1 + value)/(1 - value));
    }
}