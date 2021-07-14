package computer;

public class DivideOperator extends BinaryOperator {

    public DivideOperator(final Operand o1, final Operand o2) {
        super(o1, o2, "/", null);
    }

    @Override
    public double getValue() {
        final double result =  o1.getValue() / o2.getValue();
        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Division by zero");
        }
        return result;
    }

    @Override
    public String getLatex() {
        return "\\frac{" + o1.getLatex() + "}{" + o2.getLatex() + "}";
    }

    @Override
    boolean needBrackets(final Operand other,
                         final Position position) {
        if (position == Position.RIGHT ) {
            return other instanceof BinaryOperator &&
                    !(other instanceof PowerOperator);
        }
        return other instanceof BinaryOperator &&
               !(other instanceof PowerOperator || other instanceof MultiplyOperator);
    }
}
