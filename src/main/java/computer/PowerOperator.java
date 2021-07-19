package computer;

public class PowerOperator extends BinaryOperator {

    public PowerOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "^", "^");
    }

    @Override
    public double getValue() {
        final double result =  Math.pow(this.o1.getValue(), this.o2.getValue());
        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Invalid exponentiation");
        }
        return result;
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        return other instanceof BinaryOperator;
    }
}
