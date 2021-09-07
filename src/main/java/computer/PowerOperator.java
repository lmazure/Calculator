package computer;

public class PowerOperator extends BinaryOperator {

    public PowerOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "^", "^");
    }

    @Override
    public double getValue() {
        if ((this.o1.getValue() == 0) && (this.o2.getValue() == 0)) {
            throw new ArithmeticException("0 power 0 is undefined");
        }
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

    public static String getHelp() {
        return "Pop b from the stack\n"
                + "Pop a from the stack\n"
                + "Push a to the power b on the stack";
    }
}
