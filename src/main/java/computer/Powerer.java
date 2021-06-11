package computer;

public class Powerer extends BinaryOperator {

    public Powerer(final Operand o1, final Operand o2) {
        super(o1, o2);
    }

    @Override
    public double getValue() {
        final double result =  Math.pow(o1.getValue(), o2.getValue());
        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Invalid exponentiation");
        }
        return result;
    }

    @Override
    public String getDescription() {
        return "(" + o1.getDescription() + ") ^ (" + o2.getDescription() + ")";
    }
}
